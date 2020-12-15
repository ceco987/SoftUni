package tasks;

import entities.Employee;
import resources.Engine;

import javax.persistence.EntityManager;

public class EmployeesWithSalaryOver50000 {
    private static EntityManager entityManager;

    public static void run() {
        entityManager = Engine.entityManager;
        StringBuilder output = new StringBuilder();
        entityManager
                .createQuery("SELECT e from Employee e " +
                        "WHERE e.salary > 50000", Employee.class)
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(e -> output.append(e).append(System.lineSeparator()));
        System.out.print(output.toString().trim());
    }
}
