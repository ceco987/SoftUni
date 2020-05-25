import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Merging_Lists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstNumber = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondNumber = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        int minSize = Math.min(firstNumber.size(),secondNumber.size());
        for (int i = 0; i < minSize; i++) {
            result.add(firstNumber.get(i));
            result.add(secondNumber.get(i));
        }
        if (firstNumber.size() > secondNumber.size()) {
            for (int i = secondNumber.size(); i < firstNumber.size(); i++) {
                result.add(firstNumber.get(i));
            }
        } else {
            for (int i = firstNumber.size(); i < secondNumber.size(); i++) {
                result.add(secondNumber.get(i));
            }
        }
        System.out.println(result.toString().replaceAll("[\\[\\],]",""));
    }
}
