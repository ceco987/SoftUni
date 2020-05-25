import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][]matrix = inputMatrix(scanner,n);
        System.out.print(findSum(matrix,n));
    }

    private static int findSum(int[][] matrix, int n) {
        int sumPrimary =0;
        int sumSecondary =0;
        for (int i = 0; i < n; i++) {
            sumPrimary+=matrix[i][i];
            sumSecondary+=matrix[i][n-1-i];
        }
        return Math.abs(sumPrimary-sumSecondary);
    }

    private static int[][] inputMatrix(Scanner scanner, int n) {
    int[][]matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i]= Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
