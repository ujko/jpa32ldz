import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        Query<Employee> employeeQuery = session
                .createNamedQuery("getByFirstName", Employee.class)
                .setParameter("firstName", "Adolf");
        System.out.println(employeeQuery.getResultList());

        session.close();
        factory.close();
    }
}
