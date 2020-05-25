import java.util.Arrays;
import java.util.Scanner;

public class Equal_Sums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int []arr= Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum1=0,sum2=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                sum1+=arr[j];
            }
            for (int j = arr.length-1; j >i ; j--) {
                sum2+=arr[j];
            }
            if(sum1==sum2) {
                System.out.println(i);
                return;
            }
            sum1=0;
            sum2=0;
        }
        System.out.println("no");
    }
}
