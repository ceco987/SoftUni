import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean check = true;
        String lookUp = "{[(";

        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (lookUp.contains(temp + "")) {
                stack.push(temp);
            }
            else {
                if (stack.isEmpty()) {
                    check = false;
                    break;
                }
                char top = stack.pop();
                if (!(top == '(' && temp == ')' ||
                        top == '[' && temp == ']' ||
                        top == '{' && temp == '}')) {
                    check = false;
                    break;
                }
            }
        }

        if (check) System.out.print("YES");
        else System.out.print("NO");
    }
}
