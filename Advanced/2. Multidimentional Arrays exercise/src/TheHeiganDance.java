import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double damageToHeigan = Double.parseDouble(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");
        double heiganHealth = 3000000;
        int playerHealth = 18500;
        int playerRow = 7;
        int playerCol = 7;
        boolean cloud = false;
        boolean winner = false;
        String lastSpell = "";
        while (heiganHealth > 0 && playerHealth > 0) {
            heiganHealth -= damageToHeigan;
            if (heiganHealth <= 0) {
                winner = true;
                break;
            }
            if (cloud) {
                playerHealth -= 3500;
                cloud = false;
            }
            if (playerHealth <= 0) {
                break;
            }
            String spell = input[0];
            int spellRow = Integer.parseInt(input[1]);
            int spellCol = Integer.parseInt(input[2]);

            int tempRowUp = playerRow - 1;
            int tempRowDown = playerRow + 1;
            int tempColLeft = playerCol - 1;
            int tempColRight = playerCol + 1;

            switch (spell) {
                case "Cloud":
                    if (withinRange(playerRow, playerCol, spellRow, spellCol)) {

                        if (tempRowUp >= 0 && !withinRange(tempRowUp, playerCol, spellRow, spellCol)) {
                            playerRow = tempRowUp;
                        } else if (tempColRight < 15 && !withinRange(playerRow, tempColRight, spellRow, spellCol)) {
                            playerCol = tempColRight;
                        } else if (tempRowDown < 15 && !withinRange(tempRowDown, playerCol, spellRow, spellCol)) {
                            playerRow = tempRowDown;
                        } else if (tempColLeft >= 0 && !withinRange(playerRow, tempColLeft, spellRow, spellCol)) {
                            playerCol = tempColLeft;
                        } else {
                            playerHealth -= 3500;
                            lastSpell = "Cloud";
                            cloud = true;
                        }
                    }
                    break;
                case "Eruption":
                    if (withinRange(playerRow, playerCol, spellRow, spellCol)) {

                        if (tempRowUp >= 0 && !withinRange(tempRowUp, playerCol, spellRow, spellCol)) {
                            playerRow = tempRowUp;
                        } else if (tempColRight < 15 && !withinRange(playerRow, tempColRight, spellRow, spellCol)) {
                            playerCol = tempColRight;
                        } else if (tempRowDown < 15 && !withinRange(tempRowDown, playerCol, spellRow, spellCol)) {
                            playerRow = tempRowDown;
                        } else if (tempColLeft >= 0 && !withinRange(playerRow, tempColLeft, spellRow, spellCol)) {
                            playerCol = tempColLeft;
                        } else {
                            playerHealth -= 6000;
                            lastSpell = "Eruption";

                        }
                    }
                    break;
            }
            if (playerHealth <= 0) break;
            input = scanner.nextLine().split("\\s+");
        }
        if (winner) {
            System.out.println("Heigan: Defeated!");
            System.out.println("Player: " + playerHealth);
            System.out.print("Final position: " + playerRow + ", " + playerCol);
        } else {
            if (lastSpell.equals("Cloud")) lastSpell = "Plague Cloud";
            System.out.printf("Heigan: %.2f%n", heiganHealth);
            if (playerHealth > 0) System.out.println("Player: " + playerHealth);
            else System.out.println("Player: Killed by " + lastSpell);
            System.out.print("Final position: " + playerRow + ", " + playerCol);
        }
    }

    private static boolean withinRange(int playerRow, int playerCol, int spellRow, int spellCol) {
        return playerRow >= spellRow - 1 && playerRow <= spellRow + 1 &&
                playerCol >= spellCol - 1 && playerCol <= spellCol + 1;
    }
}

