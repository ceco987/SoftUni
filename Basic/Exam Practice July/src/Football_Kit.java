import java.util.Scanner;

public class Football_Kit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double teniskaPrice = Double.parseDouble(scanner.nextLine());
        double cena = Double.parseDouble(scanner.nextLine());
        double shortsPrice = 0.75*teniskaPrice;
        double socksPrice = 0.2*shortsPrice;
        double shoesPrice = 2*(teniskaPrice+shortsPrice);
        double total=(teniskaPrice+shortsPrice+socksPrice+shoesPrice)*0.85;
        if(total>=cena) System.out.printf("Yes, he will earn the world-cup replica ball!\nHis sum is %.2f lv.",total);
        else System.out.printf("No, he will not earn the world-cup replica ball.\nHe needs %.2f lv. more.", cena-total);
    }
}
