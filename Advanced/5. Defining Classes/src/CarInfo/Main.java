package CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String [] output = new String[n];
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car = new Car();
            car.setBrand(input[0]);
            car.setModel(input[1]);
            car.setHorsePower(Integer.parseInt(input[2]));
            output[i]=car.carInfo();
        }
        System.out.print(String.join(System.lineSeparator(),output));
    }
}
