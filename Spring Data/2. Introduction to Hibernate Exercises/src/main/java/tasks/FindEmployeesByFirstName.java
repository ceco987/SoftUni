package tasks;

import entities.Employee;
import resources.Engine;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class FindEmployeesByFirstName {
    private static EntityManager entityManager;
    private static Scanner scanner;

    public static void run(){
        entityManager = Engine.entityManager;
        scanner = Engine.scanner;
        System.out.print("Please enter your name pattern: ");
        String pattern = scanner.nextLine();
        entityManager.createQuery("SELECT e from Employee e " +
                "WHERE e.firstName like ?1", Employee.class)
                .setParameter(1,pattern+"%")
                .getResultStream()
                .forEach(e->{
                    System.out.printf("%s %s - %s - ($%.2f)%n",
                            e.getFirstName(),
                            e.getLastName(),
                            e.getJobTitle(),
                            e.getSalary());
                });
    }
}
