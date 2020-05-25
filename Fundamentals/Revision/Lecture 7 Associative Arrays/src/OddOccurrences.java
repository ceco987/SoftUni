import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        Map<String, Integer> input = new LinkedHashMap<>();
        for (String word : words) {
            String lowerWord = word.toLowerCase();
            if (input.containsKey(lowerWord)){
                input.put(lowerWord,input.get(lowerWord)+1);
            }
            else input.put(lowerWord,1);
        }
        List<String> oddWords = input.entrySet().stream().filter(e->e.getValue()%2!=0)
                                    .map(Map.Entry::getKey)
                                    .collect(Collectors.toList());
        System.out.println(String.join(", ",oddWords));
    }
}
