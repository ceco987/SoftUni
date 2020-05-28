import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        ArrayList<ArrayList<Integer>> matrix = fillMatrix(rows, cols);
        ArrayList<int[]> bombs = new ArrayList<>();

        String input = "";
        while (!"Nuke it from orbit".equals(input = scanner.nextLine())) {
            bombs.add(Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt) //get rid of this loop, maybe makes it too heavy
                    .toArray());
        }

        for (int[] bomb : bombs) {
            int bombRow = bomb[0];
            int bombCol = bomb[1];
            int bombRad = bomb[2];

            if (bombCol + bombRad >= 0 || bombCol - bombRad < matrix.get(bombRow).size() ||
                    bombRow + bombRad >= 0 || bombRow - bombRad < matrix.size()||bombRad>=0) {

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

    private static ArrayList<ArrayList<Integer>> fillMatrix(int rows, int cols) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int count=1;
        for (int row = 0; row < rows; row++) {
            ArrayList<Integer> number = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                number.add(count++);
            }
            matrix.add(number);
        }
        return matrix;
    }
}