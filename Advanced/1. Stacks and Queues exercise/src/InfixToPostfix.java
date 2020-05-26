import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s");

        String staff = "+-*/^";
        Map<String, Integer> roles = new HashMap<>() {
            {
                put("^", 3);
                put("*", 2);
                put("/", 2);
                put("+", 1);
                put("-", 1);
            }
        };

        ArrayDeque<String> numbers = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();
        int topLevel = 0;
        for (String item : input) {
            if (Character.isLetterOrDigit(item.charAt(0))) {
                numbers.offer(item);
            } else if (staff.contains(item)) {
                if (!operators.isEmpty()) {
                    int tempLevel = roles.get(item);
                    while (topLevel >= tempLevel && !"(".equals(operators.peek())) {
                        numbers.offer(operators.pop());
                        if (operators.isEmpty()) {
                            break;
                        }
                        else {
                        topLevel=roles.get(operators.peek());
                        }
                    }
                    operators.push(item);
                    topLevel = roles.get(operators.peek());
                } else {
                    operators.push(item);
                    topLevel = roles.get(operators.peek());
                }
            } else if ("(".equals(item)) {
                operators.push(item);
            } else if (")".equals(item)) {
                while (!"(".equals(operators.peek())) {
                    numbers.offer(operators.pop());
                }
                if ("(".equals(operators.peek())) {
                    operators.pop();
                }
            }
        }

        while (!operators.isEmpty()) {
            numbers.offer(operators.pop());
        }
        for (String s : numbers) {
            System.out.print(s + " ");
        }
    }
}
