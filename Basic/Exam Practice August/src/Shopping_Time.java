import java.util.Scanner;

public class Shopping_Time {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int breakTime= Integer.parseInt(scanner.nextLine());
        double partsPrice = Double.parseDouble(scanner.nextLine());
        double programPrice = Double.parseDouble(scanner.nextLine());
        double frappePrice = Double.parseDouble(scanner.nextLine());
        int freetime=breakTime-5-3*2-2*2;
        System.out.printf("%.2f\n",3*partsPrice+2*programPrice+frappePrice);
        System.out.println(freetime);
    }
}
