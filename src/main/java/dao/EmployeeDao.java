package dao;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.OptimisticLockException;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDao implements IEmployeeDao{

    private Session session;
    private SessionFactory factory;

    private void initialize() {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = factory.openSession();
    }

    private void closeSession(){
        session.close();
        factory.close();
    }
    @Override
    public List<Employee> getAllEmployees() {
        initialize();

        List<Employee> allEmployees = session.createNamedQuery(Employee.GET_ALL, Employee.class)
                .getResultList();

        closeSession();
        return allEmployees;
    }

    @Override
    public Employee getById(int id) {
        initialize();

        Employee employee = session.find(Employee.class, id);

        closeSession();
        return employee;
    }

    @Override
    public List<Employee> getByFirstName(String firstName) {
        initialize();

        List<Employee> resultList = session.createNamedQuery("getByFirstName", Employee.class)
                .setParameter("firstName", '%' + firstName + '%') //.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase()
                .getResultList();

        closeSession();
        return resultList;
    }

    @Override
    public List<Employee> getByLastName(String lastName) {
        initialize();

        List<Employee> resultList = session.createNamedQuery("getByLastName", Employee.class)
                .setParameter("lastName", '%' + lastName + '%') //.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase()
                .getResultList();

        closeSession();
        return resultList;
    }

    @Override
    public List<Employee> getEmail(String email) {
        initialize();

        List<Employee> resultList = session.createNamedQuery("getByEmail", Employee.class)
                .setParameter("email", '%' + email + '%')
                .getResultList();

        closeSession();
        return resultList;
    }

    @Override
    public List<Employee> getByBirthDateBetween(LocalDate from, LocalDate to) {
        initialize();

        List<Employee> resultList = session.createNamedQuery("getByBirthDateBetween", Employee.class)
                .setParameter("from", from).setParameter("to", to)
                .getResultList();

        closeSession();
        return resultList;
    }

    @Override
    public int addEmployee(Employee employee) {
        initialize();
        Transaction transaction = session.beginTransaction();
        Serializable save = session.save(employee);
        System.out.println(save);
        transaction.commit();
        closeSession();
        return (int) save;
    }

    @Override
    public boolean deleteEmployee(int id) {
            initialize();
            Employee employee = new Employee();
            employee.setEmployeeId(id);
            Transaction transaction = session.beginTransaction();
            boolean result = true;
            try {
                session.remove(employee);
                transaction.commit();
            } catch (Exception e) {
                result = false;
            }
            closeSession();
            return result;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        initialize();
        Transaction transaction = session.beginTransaction();
        boolean result = true;
        try {
            session.update(employee);
            transaction.commit();
        } catch (Exception e) {
            result = false;
        }
        closeSession();
        return result;
    }
}
