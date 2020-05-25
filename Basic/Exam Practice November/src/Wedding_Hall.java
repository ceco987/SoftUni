import java.util.Scanner;

public class Wedding_Hall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double l = Double.parseDouble(scanner.nextLine());
        double w = Double.parseDouble(scanner.nextLine());
        double a = Double.parseDouble(scanner.nextLine());
        double area=l*w;
        double danceHall = area*0.19;
        double freeSpace=area-danceHall-a*a;
        System.out.printf("%.0f",Math.ceil(freeSpace/3.2));
    }
}
