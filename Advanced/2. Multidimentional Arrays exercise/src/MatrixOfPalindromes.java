import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];
        String[][]matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            char firstLast = (char)(97+row);
            for (int col = 0; col < cols; col++) {
                char curr = (char)(97+row+col);
                matrix[row][col]= String.valueOf(firstLast)+String.valueOf(curr)+String.valueOf(firstLast);
            }
        }
        for (String[] strings : matrix) {
            for (String el : strings) {
                System.out.print(el+" ");
            }
            System.out.println();
        }
    }
}
