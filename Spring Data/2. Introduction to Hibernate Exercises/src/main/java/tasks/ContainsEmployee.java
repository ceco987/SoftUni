package tasks;

import entities.Employee;
import resources.Engine;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class ContainsEmployee {
    private static EntityManager entityManager;
    private static Scanner scanner;

    public static void run() {
        entityManager = Engine.entityManager;
        scanner = Engine.scanner;
        System.out.print("Enter employee full name: ");
        String empName = scanner.nextLine();
        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE concat(e.firstName,' ',e.lastName) = :name", Employee.class)
                .setParameter("name", empName)
                .getResultList();
        System.out.print(employees.size() == 0 ? "No" : "Yes");
    }
}
