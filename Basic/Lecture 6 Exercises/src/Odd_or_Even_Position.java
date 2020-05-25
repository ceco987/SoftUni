import java.text.DecimalFormat;
import java.util.Scanner;

public class Odd_or_Even_Position {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double even = 0;
        double odd = 0;
        double evensum = 0;
        double oddsum = 0;
        double evenmax = Integer.MIN_VALUE;
        double evenmin = Integer.MAX_VALUE;
        double oddmax = Integer.MIN_VALUE;
        double oddmin = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            double num = Double.parseDouble(scanner.nextLine());
            if (i % 2 == 0) {
                evensum += num;
                if (num > evenmax) evenmax = num;
                if (num < evenmin) evenmin = num;
            } else {
                oddsum += num;
                if (num > oddmax) oddmax = num;
                if (num < oddmin) oddmin = num;
            }
        }
        System.out.printf("OddSum=%s%n", df.format(oddsum));
        if (oddmin == Integer.MAX_VALUE) System.out.printf("OddMin=No%n");
        else System.out.printf("OddMin=%s%n", df.format(oddmin));
        if (oddmax == Integer.MIN_VALUE) System.out.printf("OddMax=No%n");
        else System.out.printf("OddMax=%s%n", df.format(oddmax));
        System.out.printf("EvenSum=%s%n", df.format(evensum));
        if (evenmin == Integer.MAX_VALUE) System.out.printf("EvenMin=No%n");
        else System.out.printf("EvenMin=%s%n", df.format(evenmin));
        if (evenmax == Integer.MIN_VALUE) System.out.printf("EvenMax=No%n");
        else System.out.printf("EvenMax=%s%n", df.format(evenmax));
    }
}
