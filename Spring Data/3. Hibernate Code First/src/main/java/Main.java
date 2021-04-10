import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vehicles");
        EntityManager em = emf.createEntityManager();
        Car car1 = new Car("Audi A8", new BigDecimal(56000), "hybrid", 5);
        Truck truck1 = new Truck("Fuso Canter", new BigDecimal(120000), "gasoline", 5.5);
        Plane plane1 = new Plane("Boeing", new BigDecimal(1000000), "kerosene", 120, "Dubai Air");
        Bike bike1 = new Bike("BMX",new BigDecimal(300), "no fuel");
        em.getTransaction().begin();
        em.persist(car1);
        PlateNumber car1Plate = new PlateNumber("A1454KA",car1);
        car1.setPlate(car1Plate);
        em.persist(car1Plate);
        em.persist(truck1);
        em.persist(plane1);
        em.persist(bike1);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Car found = em.find(Car.class, 1L);
        System.out.printf("Found car1: %s%n", found);
        Truck truck = em.find(Truck.class, 2L);
        System.out.printf("Found truck1: %s%n", truck);
        Plane plane = em.find(Plane.class, 3L);
        System.out.printf("Found plane1: %s%n", plane);
        Bike bike = em.find(Bike.class, 4L);
        System.out.printf("Found bike1: %s%n", bike);
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.createQuery("SELECT v FROM Vehicle v")   // WHERE c.name LIKE :name ORDER BY s.name")
//                .setParameter("name", "%")
                .getResultList().forEach(System.out::println);
        em.getTransaction().commit();
    }
}
