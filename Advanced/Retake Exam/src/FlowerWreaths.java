import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> roses = new ArrayDeque<>(); //queue
        Deque<Integer> lilies = new ArrayDeque<>(); //stack
        int leftOvers = 0;
        int wreathCount = 0;
        int[] liliesInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[] rosesInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        for (Integer lily : liliesInput) {
            lilies.push(lily);
        }
        for (int rose : rosesInput) {
            roses.offer(rose);
        }
        for (int i = 0; i < rosesInput.length; i++) {
            int lilNumber = lilies.peek();
            int rosNumber = roses.peek();
            int sum = lilNumber + rosNumber;
            boolean done = false;
            while (!done) {
                if (sum == 15) {
                    wreathCount++;
                    lilies.pop();
                    roses.poll();
                    done = true;
                } else if (sum > 15) {
                    lilNumber -= 2;
                    sum = lilNumber + rosNumber;
                } else {
                    leftOvers += lilNumber + rosNumber;
                    lilies.pop();
                    roses.poll();
                    done = true;
                }
            }
        }
        wreathCount += leftOvers / 15;
        if (wreathCount >= 5)
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathCount);
        else System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreathCount);
    }
}
