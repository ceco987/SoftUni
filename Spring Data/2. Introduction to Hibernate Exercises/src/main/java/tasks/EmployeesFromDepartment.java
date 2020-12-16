package tasks;

import entities.Employee;
import resources.Engine;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class EmployeesFromDepartment {
    private static EntityManager entityManager;
    private static Scanner scanner;

    public static void run(){
        entityManager = Engine.entityManager;
        scanner = Engine.scanner;
        System.out.print("Enter department name: ");
        String department = scanner.nextLine();
        List<Employee> employees= entityManager
                .createQuery("SELECT e from Employee e " +
                        "where e.department.name = :name " +
                        "order by e.salary, e.id", Employee.class)
                .setParameter("name",department)
                .getResultList();
        for (Employee e : employees) {
            System.out.printf("%s %s from %s - $%.2f%n",
                    e.getFirstName(),
                    e.getLastName(),
                    department,
                    e.getSalary());
        }
    }
}
