import java.util.Scanner;

public class Maiden_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double party = Double.parseDouble(scanner.nextLine());
        int loveMessage = Integer.parseInt(scanner.nextLine());
        int waxRose = Integer.parseInt(scanner.nextLine());
        int keyRing = Integer.parseInt(scanner.nextLine());
        int caricature = Integer.parseInt(scanner.nextLine());
        int surprise = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;
        double loveMessagePrice = 0.6;
        double waxRosePrice = 7.2;
        double keyRingPrice = 3.6;
        double caricaturePrice = 18.2;
        double surprisePrice = 22;
        if (loveMessage + waxRose + keyRing + caricature + surprise >= 25)
            totalPrice = (loveMessage * loveMessagePrice + waxRose * waxRosePrice + keyRing * keyRingPrice + caricature * caricaturePrice + surprise * surprisePrice) * 0.65;
        else
            totalPrice = loveMessage * loveMessagePrice + waxRose * waxRosePrice + keyRing * keyRingPrice + caricature * caricaturePrice + surprise * surprisePrice;
        totalPrice*=0.9;
        double diff=totalPrice-party;
        if(diff>=0) System.out.printf("Yes! %.2f lv left.",diff);
        else System.out.printf("Not enough money! %.2f lv needed.",Math.abs(diff));
    }
}
