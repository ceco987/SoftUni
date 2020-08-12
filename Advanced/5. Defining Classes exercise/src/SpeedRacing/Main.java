package SpeedRacing;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Car car = null;
        Set<Car> carsDatabase = new LinkedHashSet<>();
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuel = Double.parseDouble(input[1]);
            double fuelCost = Double.parseDouble(input[2]);
            carsDatabase.add(car = new Car(model, fuel, fuelCost));
        }
        String input = "";
        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");
            String model = data[1];
            double distance = Double.parseDouble(data[2]);
            for (Car currCar : carsDatabase) {
                if (currCar.getModel().equals(model)){
                    currCar.travel(distance);
                }
            }
        }
        carsDatabase.forEach(System.out::print);
    }
}