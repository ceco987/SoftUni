import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] passengers = new int[n];
        int sum=0;
        for (int i = 0; i < n; i++) {
            passengers[i]=Integer.parseInt(scanner.nextLine());
            sum+=passengers[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(passengers[i] + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
