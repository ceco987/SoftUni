import java.util.Scanner;

public class Clever_Lily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double wash = Double.parseDouble(scanner.nextLine());
        int toys = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int count = 0;
        int money = 10;
        for (int i = 1; i <= age; i++) {
            if (i % 2 != 0) count++;
            else {
                sum += money - 1;
                money += 10;
            }
        }
        sum += toys * count;
        double diff = sum - wash;
        if (diff >= 0) {
            System.out.printf("Yes! %.2f", diff);
        } else System.out.printf("No! %.2f", Math.abs(diff));

    }
}
