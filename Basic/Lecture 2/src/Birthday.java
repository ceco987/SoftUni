import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double perc = Double.parseDouble(scanner.nextLine());
        int area = length*width*height;
        double total = area * ((100-perc) / 100) * 0.001;
        System.out.printf("%.3f", total);

    }
}