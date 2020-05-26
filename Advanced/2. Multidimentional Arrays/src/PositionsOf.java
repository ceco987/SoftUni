import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = inputMatrix(scanner);
        int lookUpNumber = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == lookUpNumber) {
                    System.out.println(row + " " + col);
                    flag = true;
                }
            }
        }
        if (!flag) System.out.println("not found");

    }

    private static int[][] inputMatrix(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

}