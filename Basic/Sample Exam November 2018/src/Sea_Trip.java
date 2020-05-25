import java.util.Scanner;

public class Sea_Trip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double food = Double.parseDouble(scanner.nextLine());
        double souvenir = Double.parseDouble(scanner.nextLine());
        double hotel = Double.parseDouble(scanner.nextLine());
        double gasMoney = (7.0*420/100)*1.85;
        double fsMoney = 3*(food+souvenir);
        double hotelMoney = 0.9*hotel+0.85*hotel+0.8*hotel;
        System.out.printf("Money needed: %.2f",gasMoney+fsMoney+hotelMoney);

    }
}
