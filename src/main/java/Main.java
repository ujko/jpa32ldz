import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import relations.oneTableTwoEntities.Employee;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program działa");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Employee e = session.find(Employee.class, 4);
        System.out.println(e);
        session.close();
        factory.close();
    }

}
