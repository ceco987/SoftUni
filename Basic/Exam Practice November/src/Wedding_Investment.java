import java.util.Scanner;

public class Wedding_Investment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String contract = scanner.nextLine();
        String type = scanner.nextLine();
        String dessert = scanner.nextLine();
        int months = Integer.parseInt(scanner.nextLine());
        double small = 0;
        double middle = 0;
        double large = 0;
        double xl = 0;
        double total = 0;
        switch (contract) {
            case "one":
                small = 9.98;
                middle = 18.99;
                large = 25.98;
                xl = 35.99;
                break;
            case "two":
                small = 8.58;
                middle = 17.09;
                large = 23.59;
                xl = 31.79;
                break;
        }
        if (dessert.equals("yes")) {
            switch (type) {
                case "Small":
                    total += 5.5;
                    break;
                case "Middle":
                case "Large":
                    total += 4.35;
                    break;
                case "ExtraLarge":
                    total += 3.85;
                    break;
            }
        }
        switch (type) {
            case "Small":
                total =(total+small)* months;
                break;
            case "Middle":
                total = (total+middle)*months;
                break;
            case "Large":
                total = (total + large)*months;
                break;
            case "ExtraLarge":
                total = (total+xl)*months;
                break;
        }
        if(contract.equals("two")) total*=0.9625;
        System.out.printf("%.2f lv.",total);
    }
}
