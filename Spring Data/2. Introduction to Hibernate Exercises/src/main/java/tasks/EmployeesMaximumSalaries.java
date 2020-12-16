package tasks;

import entities.Department;
import entities.Employee;
import resources.Engine;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class EmployeesMaximumSalaries {
    private static EntityManager entityManager;

    public static void run() {
        entityManager = Engine.entityManager;
        entityManager.createQuery("SELECT d FROM Department d " +
                "JOIN Employee e ON d=e.department " +
                "GROUP BY d.name " +
                "having max(e.salary) not between 30000 and 70000", Department.class)
                .getResultStream()
                .forEach(d -> System.out.printf("%s %.2f%n", d.getName(), getMax(d)));
    }

    private static double getMax(Department d) {
        return d.getEmployees()
                .stream()
                .map(Employee::getSalary)
                .mapToDouble(BigDecimal::doubleValue)
                .max().orElse(0.0);
    }
}
