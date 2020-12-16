package tasks;

import entities.Employee;
import entities.Project;
import resources.Engine;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.Scanner;

public class GetEmployeeWithProject {

    private static EntityManager entityManager;
    private static Scanner scanner;

    public static void run(){
        entityManager = Engine.entityManager;
        scanner = Engine.scanner;
        System.out.print("Enter employee ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Employee employee = entityManager.find(Employee.class, id);
        System.out.printf("%s %s - %s%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());
        employee.getProjects().stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p->{
                    System.out.printf("\t%s%n",p.getName());
                });
    }
}
