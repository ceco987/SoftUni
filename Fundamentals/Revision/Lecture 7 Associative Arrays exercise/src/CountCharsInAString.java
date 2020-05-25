import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = String.join("",scanner.nextLine().split("\\s+"));
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (!result.containsKey(input.charAt(i))) {
             result.put(input.charAt(i),1);
            }
            else result.put(input.charAt(i),result.get(input.charAt(i))+1);
        }
        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }
}
