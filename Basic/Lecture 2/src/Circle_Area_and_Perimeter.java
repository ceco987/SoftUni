import java.util.Scanner;

public class Circle_Area_and_Perimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());
        double area = Math.PI*r*r;
        double per = 2 * Math.PI * r;
        System.out.printf("Area = %f\nPerimeter = %f", area, per);



    }
}
