package GenericBox;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box <String> box;
        int n = Integer.parseInt(scanner.nextLine());
        Box[] output = new Box[n];
        for (int i = 0; i < n; i++) {
            box = new Box<>();
            box.setTest(scanner.nextLine());
            output[i]=box;
        }
        Arrays.stream(output).forEach(System.out::println);
    }
}
