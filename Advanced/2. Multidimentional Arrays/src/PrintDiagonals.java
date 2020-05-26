import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = inputMatrixModified(scanner, n);
        for (int j = 0; j < n; j++) {
            System.out.print(matrix[j][j] + " ");
        }
        System.out.println();
        int col = 0;
        for (int row = n - 1; row >= 0; row--) {
            System.out.print(matrix[row][col] + " ");
            col++;
        }

    }

    private static String[][] inputMatrixModified(Scanner scanner, int n) {
        String[][] matrix = new String[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }
}