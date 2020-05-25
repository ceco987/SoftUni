import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] operations = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] digits = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numEl = operations[0];
        int toPoll = operations[1];
        int check = operations[2];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int count = 0;
        while (numEl-- > 0) {
            queue.offer(digits[count]);
            count++;
        }
        while (toPoll-- > 0) {
            queue.poll();
        }
        if(queue.contains(check)){
            System.out.print(true);
        }
        else if(queue.size()>0){
            System.out.print(queue.stream().min(Integer::compare).get());
        }
        else System.out.print("0");
    }
}
