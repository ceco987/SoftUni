import java.util.Scanner;

public class Square_Area {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double area = a*a;
        System.out.println(area);
    }
}