import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");
        System.out.printf("%s%n%s%n", input[0], input[1]);
        int[] numbers = new int[Integer.parseInt(input[0]) * Integer.parseInt(input[1])];
        int temp = Integer.parseInt(input[0]);
        int j = 0;
        while (temp-- > 0) {
            int[] tempImp = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < Integer.parseInt(input[1]); i++) {
                numbers[j] = tempImp[i];
                j++;
            }
        }
        System.out.println(Arrays.stream(numbers).sum());
    }
}