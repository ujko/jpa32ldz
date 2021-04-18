package relations.twoTablesOneEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import relations.oneTableTwoEntities.Employee;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        People p = new People();
        p.setName("Adam Nowak");
        p.setCity("Lodz");
        p.setStreet("Piotrkowska");
        p.setNumber("10b");
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
        factory.close();
    }

}
