package tasks;

import entities.Address;
import resources.Engine;

import javax.persistence.EntityManager;

public class AddressesWithEmployeeCount {
    private static EntityManager entityManager;

    public static void run(){
        entityManager = Engine.entityManager;
        entityManager
                .createQuery("SELECT a from Address a " +
                        "ORDER BY a.employees.size desc", Address.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(a->{
                    System.out.printf("%s, %s - %d employees%n",
                            a.getText(),
                            a.getTown().getName(),
                            a.getEmployees().size());
                });
    }
}
