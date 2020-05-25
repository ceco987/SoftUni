import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers =Arrays.stream(scanner.nextLine().split("\\s+"))
                        .collect(Collectors.toList());
        String[] bomb = scanner.nextLine().split("\\s+");
        while(numbers.contains(bomb[0])){
            int elementIndex = numbers.indexOf(bomb[0]);
            int power = Integer.parseInt(bomb[1]);
            int leftSide = Math.max(0,elementIndex-power);
            int rightSide = Math.min(elementIndex+power, numbers.size()-1);
            for (int i = rightSide; i >= leftSide; i--) {
                numbers.remove(i);
            }
        }
        System.out.println(numbers.stream().mapToInt(Integer::parseInt).sum());
    }
}
