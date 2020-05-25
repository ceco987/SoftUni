import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        int rotations = Integer.parseInt(scanner.nextLine());
        int currentRotation = 1;
        while (queue.size() > 1) {
            for (int i = 0; i < rotations-1; i++) {
                queue.offer(queue.poll());
            }
                if (isPrime(currentRotation)) {
                    System.out.println("Prime " + queue.peek());
                } else {
                    System.out.println("Removed " + queue.poll());
                }
                currentRotation++;

        }
        System.out.print("Last is " + queue.poll());
    }

    public static boolean isPrime(int number) {
        boolean flag;
        if(number==1) return false;
        if(number==2) return true;
        int count = 0;
        int n = number+1;
        while (n-- > 1) {
            if (number % n == 0) count++;
        }
        if (count > 2) {
            flag=false;
        }
        else {
            flag=true;
        }
        return flag;
    }

}
