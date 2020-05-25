import java.util.Scanner;

public class Beer_and_Chips {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        double budget = Double.parseDouble(scanner.nextLine());
        int beer=Integer.parseInt(scanner.nextLine());
        int chips = Integer.parseInt(scanner.nextLine());
        double beerPrice=1.2;
        double chipsPrice=beer*beerPrice*0.45;
        double total=beer*beerPrice+Math.ceil(chips*chipsPrice);
        if(budget>=total) System.out.printf("%s bought a snack and has %.2f leva left.",name,budget-total);
        else System.out.printf("%s needs %.2f more leva!",name,total-budget);
    }
}
