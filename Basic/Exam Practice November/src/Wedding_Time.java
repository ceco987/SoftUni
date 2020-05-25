import java.util.Scanner;

public class Wedding_Time {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double whiskeyPrice=Double.parseDouble(scanner.nextLine());
        double water=Double.parseDouble(scanner.nextLine());
        double wine = Double.parseDouble(scanner.nextLine());
        double champagne=Double.parseDouble(scanner.nextLine());
        double whiskey=Double.parseDouble(scanner.nextLine());
        double champagnePrice=whiskeyPrice/2;
        double winePrice=champagnePrice*0.4;
        double waterPrice=champagnePrice*0.1;
        double sum=water*waterPrice+whiskey*whiskeyPrice+champagne*champagnePrice+wine*winePrice;
        System.out.printf("%.2f",sum);
    }
}
