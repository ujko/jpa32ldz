import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Employee employee = session.find(Employee.class, 4);
        System.out.println(employee);
        System.out.println(employee.getBirthDateString());
//        Employee employee = session.find(Employee.class, 2);
//        System.out.println(employee);
//        Employee e = new Employee();
//        e.setEmployeeId(98);
//        e.setFirstName("Pawel");
//        e.setLastName("Nowak");
//        e.setEmail("aaaa@gmail.com");
//        e.setBirthDate(LocalDate.of(2000, 12,01));
//        Employee employee = session.find(Employee.class, 91);
//        employee.setFirstName("Adolf");
//        Transaction transaction = session.beginTransaction();

//        session.update(e);
//        session.delete(e);
//        transaction.commit();
//        String query = "select e from Employee e";
//        Query<Employee> query1 = session.createQuery(query, Employee.class);
//        query1.getResultStream().forEach(System.out::println);

        session.close();
        factory.close();
    }
}
