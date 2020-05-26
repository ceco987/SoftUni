import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][]matrix = inputMatrix(scanner);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (matrix[row][col]=='q'&&isAnswer(row, col, matrix)){
                    System.out.println(row+" "+col);
                }
            }
        }
    }

    private static boolean isAnswer(int row, int col, char[][] matrix) {
        for (int rowDir = -1; rowDir <=1 ; rowDir++) {
            for (int colDir = -1; colDir <= 1; colDir++) {
                if (rowDir==0&&colDir==0){
                    continue;
                }
                int currRow = row + rowDir;
                int currCol = col + colDir;
                boolean index = isValid(matrix,currRow,currCol);
                while (index){
                    if ('q'==matrix[currRow][currCol]){
                        return false;
                    }
                    currRow = currRow + rowDir;
                    currCol = currCol + colDir;
                    index=isValid(matrix,currRow,currCol);
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] matrix, int currRow, int currCol) {
        if (currCol>=0&&currCol<matrix.length
                &&currRow>=0&&currRow<matrix.length) {
            return true;
        }
        return false;
    }

    private static char[][] inputMatrix(Scanner scanner) {
        char[][] matrix = new char[8][8];
        for (int row = 0; row < 8; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+","").toCharArray();
        }
        return matrix;
    }
}