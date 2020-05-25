import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    private static int bigRow =0, bigCol =0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[]input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];
        int[][]matrix = inputMatrix(rows,cols,scanner);
        findMaxSum(matrix,rows,cols,bigRow,bigCol);
    }

    private static void printBiggest(int[][] matrix,int bigRow, int bigCol, int sum) {
        System.out.println("Sum = "+sum);

        for (int row = bigRow; row < bigRow+3; row++) {
            for (int col = bigCol; col < bigCol+3; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }

    private static void findMaxSum(int[][] matrix, int rows, int cols, int bigRow, int bigCol) {
    int sum = Integer.MIN_VALUE;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currSum =0;
                for (int i = row; i <row+3; i++) {
                    for (int j = col; j <col+3; j++) {
                        currSum+=matrix[i][j];
                    }
                }
                if (currSum>sum){
                    sum=currSum;
                    bigRow=row;
                    bigCol=col;
                }
            }
        }
        printBiggest(matrix,bigRow,bigCol,sum);
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
