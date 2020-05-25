import java.util.Scanner;

public class Inches_to_Centimeters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inch = Double.parseDouble(scanner.nextLine());
        double cent=inch*2.54;
        System.out.println(cent);
    }
}
