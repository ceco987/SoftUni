import java.util.Scanner;

public class Coding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int current = 0;
        String number = String.valueOf(n);
        int length = number.length();
        for (int i=1; i <= length; i++) {
            char j = number.charAt(length - i);
            current = Integer.parseInt(String.valueOf(j));
            int k = current;
            if (k == 0)
                System.out.println("ZERO");
            else {
                for (; k >= 1; k--) {
                    System.out.print((char) (current + 33));
                }
                System.out.println();
            }
        }
    }
}