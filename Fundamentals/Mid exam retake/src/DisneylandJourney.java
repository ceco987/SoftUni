import java.util.Scanner;

public class DisneylandJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cost = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double money = 0;
       // if ((cost<500||cost>10000)||(months<1||months>12)) return;
        for (int i = 1; i <= months; i++) {
            if (i % 2 != 0 && i != 1) {
                money *= 0.84;
            }
            if (i % 4 == 0) {
                money*=1.25;
            }
            money+=cost * 0.25;
        }
        if (money>=cost) System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.",money-cost);
        else System.out.printf("Sorry. You need %.2flv. more.",cost-money);
    }
}
