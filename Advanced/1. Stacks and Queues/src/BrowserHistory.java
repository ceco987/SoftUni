import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        ArrayDeque<String> sites = new ArrayDeque<>();
        String current = "";
        while (!"Home".equals(line = scanner.nextLine())) {
            if (line.equals("back")) {
                if (!sites.isEmpty()) {
                    current = sites.pop();
                } else {
                    System.out.println("no previous URLs");
                    continue;
                }
            } else {
                if (!current.equals("")) {
                    sites.push(current);
                }
                current = line;
            }
            System.out.println(current);
        }
    }
}