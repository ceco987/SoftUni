import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] territory = new String[n][n];
        int flowersCount = 0;
        for (int i = 0; i < n; i++) {
            territory[i] = scanner.nextLine().split("");
        }
        String input = "";
        boolean isOut = false;
        int[] beePosition = findBeeIndex(n, territory);
        while (!"End".equals(input = scanner.nextLine())) {
            isOut=checkIfOut(n, beePosition, input);
            if (isOut) {
                System.out.println("The bee got lost!");
                break;
            }
            flowersCount = polinateFlowers(territory, beePosition, input, flowersCount);

        }
        if (flowersCount >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowersCount);
        } else
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowersCount);
        if (!isOut) territory[beePosition[0]][beePosition[1]]="B";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(territory[i][j]);
            }
            System.out.println();
        }

    }

    private static int polinateFlowers(String[][] territory, int[] beePosition, String input, int flowersCount) {
        boolean repeat = false;
        while (true) {
            repeat=false;
            int x = beePosition[0];
            int y = beePosition[1];
            territory[x][y] = ".";
            switch (input) {
                case "up":
                    beePosition[0] -= 1;
                    if (territory[x - 1][y].equals("f")) {
                        flowersCount += 1;
                        territory[x - 1][y] = ".";
                    } else if (territory[x - 1][y].equals("O")) {
                        territory[x - 1][y] = ".";
                        repeat = true;
                    }
                    break;
                case "down":
                    beePosition[0] += 1;
                    if (territory[x + 1][y].equals("f")) {
                        flowersCount += 1;
                        territory[x + 1][y] = ".";
                    } else if (territory[x + 1][y].equals("O")) {
                        territory[x + 1][y] = ".";
                        repeat = true;
                    }
                    break;
                case "left":
                    beePosition[1] -= 1;
                    if (territory[x][y - 1].equals("f")) {
                        flowersCount += 1;
                        territory[x][y - 1] = ".";
                    } else if (territory[x][y - 1].equals("O")) {
                        territory[x][y - 1] = ".";
                        repeat = true;
                    }
                    break;
                case "right":
                    beePosition[1] += 1;
                    if (territory[x][y + 1].equals("f")) {
                        flowersCount += 1;
                        territory[x][y + 1] = ".";
                    } else if (territory[x][y + 1].equals("O")) {
                        territory[x][y + 1] = ".";
                        repeat = true;
                    }
                    break;
            }
            if (!repeat) return flowersCount;
        }
    }

    private static boolean checkIfOut(int n, int[] beePosition, String direction) {
        switch (direction) {
            case "up":
                if (beePosition[0] - 1 < 0) return true;
                break;
            case "down":
                if (beePosition[0] + 1 >= n) return true;
                break;
            case "left":
                if (beePosition[1] - 1 < 0) return true;
                break;
            case "right":
                if (beePosition[1] + 1 >= n) return true;
                break;
        }
        return false;
    }

    private static int[] findBeeIndex(int n, String[][] territory) {
        int[] beePosition = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (territory[i][j].equals("B")) {
                    beePosition[0] = i;
                    beePosition[1] = j;
                    break;
                }
            }
        }
        return beePosition;
    }
}
