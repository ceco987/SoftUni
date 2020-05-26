import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        StringBuilder output = new StringBuilder();
        ArrayDeque <String> numbers = new ArrayDeque<>();
        for (String element:input) {
            numbers.push(element);
        }
        for(String element:numbers){
            output.append(element).append(" ");
        }
        System.out.print(output.toString().trim());
    }
}