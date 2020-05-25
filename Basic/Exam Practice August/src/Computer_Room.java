import java.util.Scanner;

public class Computer_Room {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int hours = Integer.parseInt(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());
        String dayTime = scanner.nextLine();
        double price = 0;
        switch (month) {
            case "march":
            case "april":
            case "may":
                switch (dayTime) {
                    case "day":
                        price = 10.50;
                        break;
                    case "night":
                        price = 8.40;
                        break;
                }
                break;
            default:
                switch (dayTime) {
                    case "day":
                        price = 12.60;
                        break;
                    case "night":
                        price = 10.20;
                        break;
                }
        }
        if(people>=4) price*=0.9;
        if(hours>=5) price*=0.5;
        double total=price*people*hours;
        System.out.printf("Price per person for one hour: %.2f\n",price);
        System.out.printf("Total cost of the visit: %.2f",total);
    }
}
