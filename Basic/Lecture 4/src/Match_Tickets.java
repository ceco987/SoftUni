import java.util.Scanner;

public class Match_Tickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String cat = scanner.nextLine();
        int num = Integer.parseInt(scanner.nextLine());
        double trans = 0;
        if (num >= 1 && num <= 4) trans = 0.75 * budget;
        else if (num >= 5 && num <= 9) trans = 0.6 * budget;
        else if (num >= 10 && num <= 24) trans = 0.5 * budget;
        else if (num >= 25 && num <= 49) trans = 0.4 * budget;
        else if (num >= 50) trans = 0.25 * budget;
        double domati=budget-trans;
        switch (cat) {
            case "VIP":
                if (domati >= 499.99*num) {
                    domati = domati - 499.99*num;
                    System.out.printf("Yes! You have %.2f leva left.", domati);
                } else {
                    domati = 499.99*num - domati;
                    System.out.printf("Not enough money! You need %.2f leva.", domati);
                }
                break;
            case "Normal":
                if (domati >= 249.99*num) {
                    domati = domati - 249.99*num;
                    System.out.printf("Yes! You have %.2f leva left.", domati);
                } else {
                    domati = 249.99*num - domati;
                    System.out.printf("Not enough money! You need %.2f leva.", domati);
                }
                break;
        }
    }
}
