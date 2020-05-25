import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[]input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];
        int[][]matrix = inputMatrix(rows,cols,scanner);
        System.out.println("Sum = "+findMaxSum(matrix,rows,cols));
    }

    private static String findMaxSum(int[][] matrix, int rows, int cols) {
    int sum = Integer.MIN_VALUE;
    yes;
    }

    private static int[][] inputMatrix(int rows, int cols, Scanner scanner) {
    int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row]= Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
