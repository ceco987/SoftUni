package tasks;

import entities.Employee;
import resources.Engine;

import javax.persistence.EntityManager;

public class IncreaseSalaries {
    private static final EntityManager entityManager = Engine.entityManager;

    public static void run(){
        entityManager.getTransaction().begin();
        entityManager.createQuery("UPDATE Employee e " +
                "SET e.salary = e.salary * 1.12 " +
                "WHERE e.department.id IN (1,2,4,11)")
                .executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.department.name in ('Engineering','Tool Design','Marketing','Information Services')", Employee.class)
                .getResultStream()
                .forEach(e->{
                    System.out.printf("%s %s ($%.2f)%n",
                            e.getFirstName(),
                            e.getLastName(),
                            e.getSalary());
                });
    }
}
