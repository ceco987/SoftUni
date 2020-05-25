import java.util.Scanner;

public class C_to_F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        double cel = Double.parseDouble(scanner.nextLine());
        double far = cel*1.8+32;
        System.out.printf("%.2f",far);

    }
}
