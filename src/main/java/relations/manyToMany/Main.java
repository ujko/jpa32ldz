package relations.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import relations.oneToMany.Car;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        Developer dev1 = new Developer();
        dev1.setDevName("Dev1");
        Developer dev2 = new Developer();
        dev2.setDevName("Dev2");
        Developer dev3 = new Developer();
        dev3.setDevName("Dev3");

        Project p4 = new Project();
        p4.setProjName("Project4");

        Project p5 = new Project();
        p5.setProjName("Project5");

        dev1.addProject(p4);
        dev1.addProject(p5);

        dev2.addProject(p4);

        dev3.addProject(p5);


        Transaction tx = session.beginTransaction();
        session.save(dev1);
        session.save(dev2);
        session.save(dev3);
        session.save(p4);
        session.save(p5);
        tx.commit();


        session.close();
        factory.close();
    }

}
