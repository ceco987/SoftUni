import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numbers =new ArrayDeque<>();
        numbers.push(Integer.parseInt(input[0]));
        int sum=0;

        for (int i = 1; i < input.length; i++) {
            if ("+".equals(input[i])){
                sum=numbers.pop()+Integer.parseInt(input[i+1]);
                numbers.push(sum);
            }
            else if("-".equals(input[i])){
                sum=numbers.pop()-Integer.parseInt(input[i+1]);
                numbers.push(sum);
            }
        }
        System.out.println(numbers.peek());
    }
}
