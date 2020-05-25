import java.util.Scanner;

public class Numbers_in_Reverse_Order {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] num = new int[n];
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(scanner.nextLine());
            num [i] = index;
        }
        for (int i = n-1; i >= 0 ; i--) {
            System.out.print(num[i]+" ");
        }
    }
}
