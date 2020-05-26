import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] firstMatrix = inputMatrix(scanner);
        int[][] secondMatrix = inputMatrix(scanner);

        if (firstMatrix.length!=secondMatrix.length||
                firstMatrix[0].length!=secondMatrix[0].length){
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[0].length; col++) {
                if (firstMatrix[row][col]!=secondMatrix[row][col]){
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");
    }

    private static int[][] inputMatrix(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][]matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            input=scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }
        return matrix;
    }
}