import java.util.Scanner;

public class Sequence_2k_plus_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int a=1;
        while (a<=n) {
            System.out.println(a);
            a=a*2+1;
        }
    }
}
