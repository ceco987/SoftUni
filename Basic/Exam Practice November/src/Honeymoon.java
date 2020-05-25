import java.util.Scanner;

public class Honeymoon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String city = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double nightPrice = 0;
        double ticketPrice = 0;
        switch (city) {
            case "Cairo":
                nightPrice = 250 * 2;
                ticketPrice = 600;
                break;
            case "Paris":
                nightPrice = 150 * 2;
                ticketPrice = 350;
                break;
            case "Lima":
                nightPrice = 400 * 2;
                ticketPrice = 850;
                break;
            case "New York":
                nightPrice = 300 * 2;
                ticketPrice = 650;
                break;
            case "Tokyo":
                nightPrice = 350 * 2;
                ticketPrice = 700;
                break;
        }
        double totalPrice = nightPrice * nights + ticketPrice;
        if (nights < 5) {
            if (city.equals("Cairo") || city.equals("New York"))
                totalPrice *= 0.97;
        } else if (nights < 10) {
            if (city.equals("Cairo") || city.equals("New York"))
                totalPrice *= 0.95;
            else if (city.equals("Paris")) totalPrice *= 0.93;
        } else if (nights < 25) {
            if (city.equals("Cairo"))
                totalPrice *= 0.90;
            else if (city.equals("Paris") || city.equals("New York") || city.equals("Tokyo")) totalPrice *= 0.88;
        } else if (nights < 50) {
            if (city.equals("Tokyo") || city.equals("Cairo")) totalPrice *= 0.83;
            else if (city.equals("New York") || city.equals("Lima")) totalPrice *= 0.81;
            else if (city.equals("Paris")) totalPrice *= 0.78;
        } else totalPrice *= 0.7;
        double diff = totalPrice - budget;
        if (diff > 0) System.out.printf("Not enough money! You need %.2f leva.", diff);
        else System.out.printf("Yes! You have %.2f leva left.", Math.abs(diff));
    }
}