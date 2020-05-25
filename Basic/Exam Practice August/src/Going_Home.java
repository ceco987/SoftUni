import java.util.Scanner;

public class Going_Home {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int km = Integer.parseInt(scanner.nextLine());
        int milage = Integer.parseInt(scanner.nextLine());
        double gasPrice = Double.parseDouble(scanner.nextLine());
        int money = Integer.parseInt(scanner.nextLine());
        double expanses=(milage*1.0*km/100)*gasPrice;
        double diff=money-expanses;
        if(diff>=0) System.out.printf("You can go home. %.2f money left.",diff);
        else System.out.printf("Sorry, you cannot go home. Each will receive %.2f money.",(double)money/5);
    }
}
