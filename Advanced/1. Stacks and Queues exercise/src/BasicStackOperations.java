import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] operations = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] digits = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numEl = operations[0];
        int toPop = operations[1];
        int check = operations[2];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        while (numEl-- > 0) {
            stack.push(digits[count]);
            count++;
        }
        while (toPop-- > 0) {
            stack.pop();
        }
        if(stack.contains(check)){
            System.out.print(true);
        }
        else if(stack.size()>0){
            System.out.print(stack.stream().min(Integer::compare).get());
        }
        else System.out.print("0");
    }
}
