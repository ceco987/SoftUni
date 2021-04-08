package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school_jpa");
        EntityManager em = emf.createEntityManager();
        Student student = new Student("Grigor Pavlov");
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Student found = em.find(Student.class,1L);
        System.out.printf("Found student %s", found);
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.createQuery("SELECT s FROM Student as s WHERE s.name LIKE :name")
                .setParameter("name","G%")
                .getResultList().forEach(System.out::println);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Student removed = em.find(Student.class,1L);
        em.remove(removed);
        System.out.printf("Removed entity: %s",removed);
        em.getTransaction().commit();

        em.close();
    }
}
