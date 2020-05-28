import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int count = 1;
        for (int row = 0; row < rows; row++) {
            ArrayList<Integer> number = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                number.add(count++);
            }
            matrix.add(number);
        }

        String input = "";
        while (!"Nuke it from orbit".equals(input = scanner.nextLine())) {

            int[] bombs = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int bombRow = bombs[0];
            int bombCol = bombs[1];
            int bombRad = bombs[2];

            for (int i = bombCol - bombRad; i <= bombCol + bombRad; i++) {
                if (bombRow >= 0 && bombRow < matrix.size() && i >= 0 && i < matrix.get(bombRow).size()) {
                    matrix.get(bombRow).set(i, -1);
                }
            }

            for (int i = bombRow - bombRad; i <= bombRow + bombRad; i++) {
                if (i >= 0 && i < matrix.size() && bombCol >= 0 && bombCol < matrix.get(i).size()) {
                    matrix.get(i).set(bombCol, -1);
                }
            }

            for (ArrayList<Integer> el : matrix) {
                el.removeIf(e -> e == -1);
            }
            matrix.removeIf(ArrayList::isEmpty);

        }

        printMatrix(matrix);
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            for (Integer el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}