import java.util.Scanner;

public class Substitute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int x = k; x <= 8; x++) {
            if (x % 2 == 0) {
                for (int i = 9; i >= l; i--) {
                    if (i % 2 != 0) {
                        for (int y = m; y <= 8; y++) {
                            if (y % 2 == 0) {
                                for (int j = 9; j >= n; j--) {
                                    if (j % 2 != 0) {
                                        if (x == y && i == j) {
                                            System.out.println("Cannot change the same player.");
                                        } else {
                                            System.out.printf("%d%d - %d%d\n", x, i, y, j);
                                            count++;
                                            if (count == 6) return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}