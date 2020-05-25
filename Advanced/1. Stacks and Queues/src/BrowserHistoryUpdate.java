import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        ArrayDeque<String> sites = new ArrayDeque<>();
        ArrayDeque<String> forwards = new ArrayDeque<>();
        String current = "";

        while (!"Home".equals(line = scanner.nextLine())) {
            switch (line) {
                case "back":
                    if (!sites.isEmpty()) {
                        forwards.push(current);
                        current = sites.pop();
                    } else {
                        System.out.println("no previous URLs");
                        continue;
                    }
                    break;
                case"forward":
                    if(!forwards.isEmpty()) {
                        sites.push(forwards.pop());
                        current=sites.peek();
                    }
                    else {
                        System.out.println("no next URLs");
                        continue;
                    }
                    break;
                default:
                    if (!"".equals(current)) {
                        sites.push(current);
                    }
                    current = line;
                    forwards.clear();
                    break;
            }
            System.out.println(current);
        }
    }
}