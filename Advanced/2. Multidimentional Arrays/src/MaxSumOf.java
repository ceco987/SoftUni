import java.util.Arrays;
import java.util.Scanner;

public class MaxSumOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][]matrix = inputMatrix(scanner, rows, cols);
        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int row = 0; row < rows-1; row++) {
            for (int col = 0; col < matrix[row].length-1; col++) {
                int currSum = matrix[row][col]+matrix[row+1][col]+matrix[row][col+1]+matrix[row+1][col+1];
                if (currSum>maxSum){
                    maxSum=currSum;
                    maxRow=row;
                    maxCol=col;
                }
            }
        }

        System.out.println(matrix[maxRow][maxCol]+" "+matrix[maxRow][maxCol+1]);
        System.out.println(matrix[maxRow+1][maxCol]+" "+matrix[maxRow+1][maxCol+1]);
        System.out.print(maxSum);
    }

    private static int[][] inputMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}