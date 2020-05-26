import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char [][] firstMatrix = inputMatrix(scanner,rows,cols);
        char [][] secondMatrix = inputMatrix(scanner,rows,cols);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col]==secondMatrix[row][col]){
                    System.out.print(firstMatrix[row][col]+" ");
                }
                else{
                    System.out.print('*'+" ");
                }
            }
            System.out.println();
        }

    }

    private static char[][] inputMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+","").toCharArray();
        }
        return matrix;
    }

}