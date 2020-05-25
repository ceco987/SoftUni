import java.util.Scanner;

public class School_Supplies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int penCount = Integer.parseInt(scanner.nextLine());
        int highCount = Integer.parseInt(scanner.nextLine());
        double chemicalCount = Double.parseDouble(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double penPrice = 5.80;
        double highPrice = 7.20;
        double chemicalPrice = 1.20;
        double sum=penCount*penPrice+highCount*highPrice+chemicalCount*chemicalPrice;
        double total=sum*(100-discount)/100;

        System.out.printf("%.3f",total);
    }
}
