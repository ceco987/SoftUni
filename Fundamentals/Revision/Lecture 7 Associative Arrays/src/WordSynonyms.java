import java.util.*;
import java.util.stream.Collectors;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map <String, List<String>> input = new LinkedHashMap<>();
        while(n-->0){
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            input.putIfAbsent(word,new ArrayList<>());
            input.get(word).add(synonym);
        }
        for (Map.Entry<String, List<String>> entry : input.entrySet()) {
            System.out.println(entry.getKey()+" - "+ String.join(", ",entry.getValue()));
        }
    }
}
