package relations.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import relations.oneTableTwoEntities.Employee;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
//        CarOwner owner = new CarOwner();
//        owner.setName("Tadeusz");
//        Car car1 = new Car();
//        car1.setName("BMW");
//        Car car2 = new Car();
//        car2.setName("Syrenka");
//        owner.addCar(car1);
//        owner.addCar(car2);
//        Transaction tx = session.beginTransaction();
////        session.save(car1);
////        session.save(car2);
//        session.save(owner);
//        tx.commit();

        Car car = session.find(Car.class, 2);
        System.out.println(car);
        System.out.println(car.getCarOwner());

//        CarOwner owner = session.find(CarOwner.class, 3);
//
//        System.out.println("to wykonuję po find ale przed wypisaniem");
//
//
//        owner.getCars().forEach(System.out::println);

        session.close();
        factory.close();
//        System.out.println(owner);
    }

}
