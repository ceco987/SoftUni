package resources;

import tasks.ChangeCasing;
import tasks.ContainsEmployee;
import tasks.EmployeesWithSalaryOver50000;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class Engine implements Runnable {

    public static EntityManager entityManager;
    public static Scanner scanner;

    public Engine(EntityManager entityManager) {
        Engine.entityManager = entityManager;
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.print("Please select task 2 - 13 or hit <Enter> for full list: ");
        String input = scanner.nextLine().trim();
        int task = 0;
        while ("".equals(input)) {
            System.out.println("2. Change Casing");
            System.out.println("3. Contains Employee");
            System.out.println("4. Employees with Salary Over 50,000");
            System.out.println("5. Employees from Department");
            System.out.println("6. Adding a New Address and Updating Employee");
            System.out.println("7. Addresses with Employee Count");
            System.out.println("8. Get Employee with Project");
            System.out.println("9. Find Latest 10 Projects");
            System.out.println("10. Increase Salaries");
            System.out.println("11. Find Employees by First Name");
            System.out.println("12. Employees Maximum Salaries");
            System.out.println("13. Remove Towns");
            System.out.println();
            System.out.print("Please select task 2 - 13 or hit <Enter> for full list: ");
            input = scanner.nextLine().trim();
        }
        try {
            task = Integer.parseInt(input);
            switch (task) {
                case 2 -> ChangeCasing.run();
                case 3 -> ContainsEmployee.run();
                case 4 -> EmployeesWithSalaryOver50000.run();
                default -> invalidInputMessage();
            }
        } catch (NumberFormatException e) {
            invalidInputMessage();
        }
    }

    private void invalidInputMessage() {
        System.err.print("Invalid input, please restart the program.");
        System.exit(0);
    }

}
