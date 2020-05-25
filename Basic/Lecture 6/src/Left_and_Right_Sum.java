import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Left_and_Right_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int leftsum = 0;
        int rightsum = 0;
        for (int i = 0; i <n*2; i++) {
        int num=Integer.parseInt(scanner.nextLine());
        if(i<n){
            leftsum+=num;
        }
        else rightsum+=num;
        }
        if(leftsum==rightsum) System.out.printf("Yes, sum = %d",leftsum);
        else System.out.printf("No, diff = %d",Math.abs(leftsum-rightsum));
    }
}

