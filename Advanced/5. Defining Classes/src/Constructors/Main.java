package Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] output = new String[n];
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car = new Car();
            switch (input.length) {
                case 1:
                    car = new Car(input[0]);
                    break;
                case 2:
                    car = new Car (input[0],input[1]);
                    break;
                case 3:
                    car = new Car (input[0],input[1],Integer.parseInt(input[2]));
            }
            output[i] = car.carInfo();
        }
        System.out.print(String.join(System.lineSeparator(), output));
    }
}
