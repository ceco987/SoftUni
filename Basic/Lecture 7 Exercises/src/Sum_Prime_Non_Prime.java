import java.util.Scanner;

public class Sum_Prime_Non_Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int sumPrime = 0;
        int sumNon = 0;
        int count = 0;
        while (!num.equals("stop")) {
            int a = Integer.parseInt(num);
            if (a < 0) {
                System.out.println("Number is negative.");
            } else {
                for (int i = a; i >=1; i--) {
                    if (a % i == 0) count++;
                }
                if (count == 2) sumPrime += a;
                else sumNon += a;
                count = 0;
            }
            num = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d\n", sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d\n", sumNon);
    }
}
