import java.util.Scanner;

public class Triangle_Of_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int line = 1; line <=n ; line++) {
            for (int row = 1; row <=line ; row++) {
                System.out.print(line+" ");
            }
            System.out.println();

        }
    }
}
