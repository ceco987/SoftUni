import java.util.Scanner;

public class Toy_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pr = Double.parseDouble(scanner.nextLine());
        int jig = Integer.parseInt(scanner.nextLine());
        int doll = Integer.parseInt(scanner.nextLine());
        int teddy = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());
        int lorr = Integer.parseInt(scanner.nextLine());
        int amm = jig + doll + teddy + min + lorr;
        double cash = jig * 2.6 + doll * 3 + teddy * 4.1 + min * 8.2 + lorr * 2;
        if (amm < 50) {
            double ost = cash * 0.9;
            double resto=Math.abs(ost-pr);
            if (ost >= pr) {
                System.out.printf("Yes! %.2f lv left.", resto);
            } else {
                System.out.printf("Not enough money! %.2f lv needed.", resto);
            }

        } else {
            cash = cash * 0.75;
            double ost = cash * 0.9;
            double resto=Math.abs(ost-pr);
                    ;
            if (ost >= pr) {

                System.out.printf("Yes! %.2f lv left.", resto);
            } else {
                System.out.printf("Not enough money! %.2f lv needed.", resto);
            }
        }
    }
}
