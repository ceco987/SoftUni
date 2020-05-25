import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");
        int size = Integer.parseInt(input[0]);
        char pattern = input[1].charAt(0);
        String[][] matrix = new String[size][size];
        int count=1;
        fillMatrixByPattern(size, pattern, matrix, count);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String el : strings) {
                System.out.print(el+" ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixByPattern(int size, char pattern, String[][] matrix, int count) {
        if (pattern == 'A') {
            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                matrix[row][col]=String.valueOf(count);
                count++;
                }
            }
        }
        else if (pattern=='B'){
            for (int col = 0; col < size; col++) {
                if (col%2==0) {
                    for (int row = 0; row < size; row++) {
                    matrix[row][col]=String.valueOf(count);
                    count++;
                    }
                }
                else {
                    for (int row = size-1; row >=0 ; row--) {
                        matrix[row][col]=String.valueOf(count);
                        count++;
                    }
                }
            }
        }
    }
}
