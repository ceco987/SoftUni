import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int capacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] command = input.split("\\s+");
            if ("Add".equals(command[0])) {
                wagons.add(Integer.parseInt(command[1]));
            } else {
                for (int i = 0; i < wagons.size(); i++) {
                    if (capacity >= wagons.get(i) + Integer.parseInt(command[0])) {
                        wagons.set(i, wagons.get(i) + Integer.parseInt(command[0]));
                        break;
                    }
                }

            }
            input= scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}

