package tasks;

import entities.Employee;
import resources.Engine;

import javax.persistence.EntityManager;

public class EmployeesWithSalaryOver50000 {
    private static EntityManager entityManager;

    public static void run() {
        entityManager = Engine.entityManager;

        entityManager
                .createQuery("SELECT e from Employee e " +
                        "WHERE e.salary > 50000", Employee.class)
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }
}
