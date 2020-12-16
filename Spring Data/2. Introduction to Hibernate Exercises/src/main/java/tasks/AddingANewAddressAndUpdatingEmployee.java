package tasks;

import entities.Address;
import entities.Employee;
import entities.Town;
import resources.Engine;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class AddingANewAddressAndUpdatingEmployee {
    private static EntityManager entityManager;
    private static Scanner scanner;

    public static void run(){
        entityManager = Engine.entityManager;
        scanner = Engine.scanner;
        System.out.print("Enter employee last name: ");
        String lastName = scanner.nextLine();
        Town inputTown = entityManager
                .createQuery("SELECT t from Town t " +
                        "where t.name = 'Sofia'",Town.class)
                .getSingleResult();
        entityManager.getTransaction().begin();
        Address newAddress = new Address();
        newAddress.setTown(inputTown);
        newAddress.setText("Vitoshka 15");
        entityManager.persist(newAddress);
        Employee employee = entityManager
                .createQuery("SELECT e from Employee e " +
                        "WHERE e.lastName = :name",Employee.class)
                .setParameter("name",lastName)
                .getSingleResult();
        employee.setAddress(newAddress);
        entityManager.getTransaction().commit();
    }
}
