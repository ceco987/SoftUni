import resources.Engine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();
        Engine engine = new Engine(entityManager);
        engine.run();
        System.out.println("neshto");
    }
}