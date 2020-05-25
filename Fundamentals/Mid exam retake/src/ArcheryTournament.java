import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine().split("\\|+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String[] input = scanner.nextLine().split("\\s+");
        int points = 0;
        while (!input[0].equals("Game")) {
            switch (input[0]) {
                case "Shoot":
                    String[] distance = input[1].split("@");
                    int index = Integer.parseInt(distance[1]);
                    int count = index;
                    if (index >= 0 && index < targets.size()) {
                        int length = Integer.parseInt(distance[2]);
                        if (distance[0].equals("Left")) {

                            for (int i = length; i >= 0; i--) {

                                if (i == 0) {
                                    if (targets.get(count) <= 5) {
                                        points += targets.get(count);
                                        targets.set(count, 0);
                                    } else {
                                        points += 5;
                                        targets.set(count, targets.get(count) - 5);
                                    }
                                }
                                count--;
                                if (count < 0) {
                                    count = targets.size() - 1;
                                }

                            }
                        } else if (distance[0].equals("Right")) {
                            for (int i = length; i >= 0; i--) {

                                if (i == 0) {
                                    if (targets.get(count) <= 5) {
                                        points += targets.get(count);
                                        targets.set(count, 0);
                                    } else {
                                        points += 5;
                                        targets.set(count, targets.get(count) - 5);
                                    }
                                }
                                count++;
                                if (count >= targets.size()) {
                                    count = 0;
                                }

                            }
                        }
                    }
                    break;
                case "Reverse":
                    Collections.reverse(targets);
                    break;
            }
            input = scanner.nextLine().split("\\s+");
        }
        String output ="";
        for (int i = 0; i < targets.size(); i++) {
            if (i<targets.size()-1){
                output+=targets.get(i)+" - ";
            }
            else output+=targets.get(i);
        }
        System.out.println(output);
        System.out.printf("Iskren finished the archery tournament with %d points!", points);
    }
}
