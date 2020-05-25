import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class List_Manipulation_Advanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) break;
            String[] command = line.split(" ");
            switch (command[0]) {
                case "Contains":
                    boolean contains = numbers.contains(Integer.parseInt(command[1]));
                    if (contains) System.out.println("Yes");
                    else System.out.println("No such number");
                    break;
                case "Print":
                    switch (command[1]) {
                        case "even":
                            for (Integer number : numbers) {
                                if (number % 2 == 0) System.out.print(number + " ");
                            }
                            System.out.println();
                            break;
                        case "odd":
                            for (Integer number : numbers) {
                                if (number % 2 != 0) System.out.print(number + " ");
                            }
                            System.out.println();
                            break;
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (Integer number : numbers) {
                        sum += number;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    switch (command[1]) {
                        case "<=":
                            for (Integer number1 : numbers) {
                                if (number1 <= Integer.parseInt(command[2])) System.out.print(number1 + " ");
                            }
                            System.out.println();
                            break;
                        case ">=":
                            for (Integer number : numbers) {
                                if (number >= Integer.parseInt(command[2])) System.out.print(number + " ");
                            }
                            System.out.println();
                            break;


                        case "<":
                            for (Integer number : numbers) {
                                if (number < Integer.parseInt(command[2])) System.out.print(number + " ");
                            }
                            System.out.println();
                            break;
                        case ">":
                            for (Integer number : numbers) {
                                if (number > Integer.parseInt(command[2])) System.out.print(number + " ");
                            }
                            System.out.println();
                            break;
                    }
                break;
            }
        }
    }
}
