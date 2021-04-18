import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("test");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Arrays.stream(args).forEach(x -> showData(session, x));
        session.close();
        factory.close();
    }

    private static void showData(Session session, String name) {
        Query<Employee> employeeQuery = session
                .createNamedQuery("getByFirstName", Employee.class)
                .setParameter("firstName", name);
        System.out.println(employeeQuery.getResultList());
    }
}
