package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engineMap = new HashMap<>();
        Set<Car> cars = new LinkedHashSet<>();
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            Engine engine;
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            switch (input.length) {
                case 2:
                    engine = new Engine(model, power);
                    break;
                case 3:
                    try {
                        int displacement = Integer.parseInt(input[2]);
                        engine = new Engine(model, power, displacement);
                    } catch (NumberFormatException e) {
                        String efficiency = input[2];
                        engine = new Engine(model, power, efficiency);
                    }
                    break;
                default:
                    int displacement = Integer.parseInt(input[2]);
                    String efficiency = input[3];
                    engine = new Engine(model, power, displacement, efficiency);
                    break;
            }
            engineMap.put(model, engine);
        }
        n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car;
            String model = input[0];
            String engineModel = input[1];
            switch (input.length) {
                case 2:
                    car = new Car(model, engineMap.get(engineModel));
                    break;
                case 3:
                    try {
                        int weight = Integer.parseInt(input[2]);
                        car = new Car(model, engineMap.get(engineModel), weight);
                    } catch (NumberFormatException e) {
                        String color = input[2];
                        car = new Car(model, engineMap.get(engineModel), color);
                    }
                    break;
                default:
                    int weight = Integer.parseInt(input[2]);
                    String color = input[3];
                    car = new Car(model, engineMap.get(engineModel), weight, color);
                    break;
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
