package tasks;

import entities.Employee;
import resources.Engine;

import javax.persistence.EntityManager;

public class IncreaseSalaries {
    private static final EntityManager entityManager = Engine.entityManager;

    public static void run(){
        entityManager.getTransaction().begin();
        //todo: find out why this doesn't work... it works with IDs, but not with strings and only in the update statement.
        entityManager.createQuery("UPDATE Employee e " +
                "SET e.salary = e.salary / 1.12 " +
                "WHERE e.department.name in ('Engineering','Tool Design','Marketing','Information Services')")
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
