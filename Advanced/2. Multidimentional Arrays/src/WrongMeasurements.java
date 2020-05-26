import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = inputMatrix(scanner);
        int[][] output = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            output[i]=new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                output[i][j]=matrix[i][j];
            }
        }

        String[] lookUpCoor = scanner.nextLine().split("\\s+");
        int lookUpRow = Integer.parseInt(lookUpCoor[0]);
        int lookUpCol = Integer.parseInt(lookUpCoor[1]);
        int lookUp = matrix[lookUpRow][lookUpCol];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (checkIfLookUp(matrix[row][col], lookUp)){
                    continue;
                }
                sumCalculation(matrix,output,lookUp,row,col);
            }
        }
        for (int[] row : output) {
            for (int el : row) {
                System.out.print(el+" ");
            }
            System.out.println();
        }
    }

    private static void sumCalculation(int[][] matrix, int[][]test, int lookUp, int row, int col) {
        int sum = 0;
        if (row-1>=0&&checkIfLookUp(matrix[row-1][col],lookUp)){
            sum+=matrix[row-1][col];
        }
        if (row+1<matrix.length&&checkIfLookUp(matrix[row+1][col],lookUp)){
            sum+=matrix[row+1][col];
        }
        if (col-1>=0&&checkIfLookUp(matrix[row][col-1],lookUp)) {
            sum += matrix[row][col - 1];
        }
        if (col+1<matrix[row].length&&checkIfLookUp(matrix[row][col+1],lookUp)){
            sum+=matrix[row][col+1];
        }
        test[row][col]=sum;
    }

    private static boolean checkIfLookUp(int number, int lookUp) {
        return number !=lookUp;
    }

    private static int[][] inputMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        int[][]matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}