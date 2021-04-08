package tasks;

import entities.Address;
import entities.Employee;
import entities.Town;
import resources.Engine;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class RemoveTown {
    private static EntityManager entityManager;
    private static Scanner scanner;

    public static void run(){
        entityManager = Engine.entityManager;
        scanner = Engine.scanner;
        System.out.print("Please enter town name: ");
        String town = scanner.nextLine();

        int townId = entityManager.createQuery("SELECT t from Town as t " +
                "WHERE t.name = :name",Town.class)
                .setParameter("name",town)
                .getSingleResult().getId();
        int newTownId = townId == 1 ? 2 : 1;

        Address newAddress = entityManager.createQuery("SELECT a FROM Address a " +
                "WHERE a.town.id = ?1",Address.class)
                .setParameter(1,newTownId)
                .setMaxResults(1)
                .getResultList()
                .get(0);

        entityManager.getTransaction().begin();
        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.address.town.id = ?1", Employee.class)
                .setParameter(1,townId)
                .getResultStream()
                .forEach(e->e.setAddress(newAddress));
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        int affected = entityManager.createQuery("DELETE FROM Address a " +
                "WHERE a.town.id = ?1")
                .setParameter(1,townId)
                .executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Town t " +
                "WHERE t.id = ?1")
                .setParameter(1,townId)
                .executeUpdate();
        entityManager.getTransaction().commit();

        String suffix = affected!=1 ? "es" : "";
        System.out.printf("%d address%s in %s deleted",
                affected,suffix,town);
    }
}
