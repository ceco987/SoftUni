package CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();

        while(n-->0){
            String[]input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String dep = input [3];
            Employee employee;
            switch(input.length){
                case 4:
                    employee = new Employee(name, salary, position, dep);
                    break;
                case 5:
                    try{
                        int age = Integer.parseInt(input [4]);
                        employee = new Employee(name, salary, position, dep, age);
                    }
                    catch (NumberFormatException e){
                        employee = new Employee(name, salary, position, dep, input[4]);
                    }
                    break;
                default:
                    employee = new Employee(name, salary, position, dep, input[4], Integer.parseInt(input[5]));
                    break;
                }
            departments.putIfAbsent(dep,new Department(dep));
            departments.get(dep).getEmployees().add(employee);
        }

        Department maxDep = departments.entrySet().stream()
                .max(Comparator.comparingDouble(f -> f.getValue().getAvgSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxDep.getName());

        maxDep.getEmployees().stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

    }
}
