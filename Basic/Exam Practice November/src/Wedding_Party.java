import java.util.Scanner;

public class Wedding_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guests = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        if(guests*20>budget) System.out.printf("They won't have enough money to pay the covert. They will need %d lv more.",guests*20-budget);
        else {
            int diff=budget-20*guests;
            double fireworks=diff*0.4;
            double charity=diff*0.6;
            System.out.printf("Yes! %.0f lv are for fireworks and %.0f lv are for donation.",fireworks,charity);
        }
    }
}
