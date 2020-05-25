import java.util.Scanner;

public class Rectangle_Area_in_Coord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double area = Math.abs(x1-x2)*Math.abs(y2-y1);
        double per = 2*Math.abs(x1-x2)+2*Math.abs(y2-y1);
        System.out.printf("%f%n%f",area,per);

    }
}
