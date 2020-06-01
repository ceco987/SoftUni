import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> digits = new LinkedHashMap<>();
        for (double number : numbers) {
            if (!digits.containsKey(number)){
                digits.put(number,1);
            }
            else {
                digits.put(number, digits.get(number)+1);
            }
        }
        for (Map.Entry<Double, Integer> entry : digits.entrySet()) {
            System.out.println(String.format("%.1f",entry.getKey())+" -> "+entry.getValue());
        }
    }
}
