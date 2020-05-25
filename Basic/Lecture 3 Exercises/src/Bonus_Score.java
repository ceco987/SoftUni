import java.util.Scanner;

public class Bonus_Score {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        double bonus = 0;
        if (a <= 100) {
            if (a % 5 == 0) {
                if (a % 10 != 0) {
                    bonus = 7;
                    System.out.printf("%f\n%f", bonus, bonus + a);
                } else {
                    bonus = 6;
                    System.out.printf("%f\n%f", bonus, bonus + a);
                }
            } else if (a % 2 == 0) {
                bonus = 6;
                System.out.printf("%f\n%f", bonus, bonus + a);
            } else {
                bonus = 5;
                System.out.printf("%f\n%f", bonus, bonus + a);
            }
        } else if (a <= 1000) {
            bonus = a * 0.2;
            if (a % 5 == 0) {
                if (a % 10 != 0) {
                    bonus = bonus + 2;
                    System.out.printf("%f\n%f", bonus, bonus + a);
                } else {
                    bonus = bonus + 1;
                    System.out.printf("%f\n%f", bonus, bonus + a);
                }
            } else if (a % 2 == 0) {
                bonus = bonus + 1;
                System.out.printf("%f\n%f", bonus, bonus + a);
            } else {
                System.out.printf("%f\n%f", bonus, bonus + a);
            }
        }
        else{
            bonus=a*0.1;
            if (a % 5 == 0) {
                if (a % 10 != 0) {
                    bonus = bonus + 2;
                    System.out.printf("%f\n%f", bonus, bonus + a);
                } else {
                    bonus = bonus + 1;
                    System.out.printf("%f\n%f", bonus, bonus + a);
                }
            } else if (a % 2 == 0) {
                bonus = bonus + 1;
                System.out.printf("%f\n%f", bonus, bonus + a);
            } else {
                System.out.printf("%f\n%f", bonus, bonus + a);
            }
        }
    }
}