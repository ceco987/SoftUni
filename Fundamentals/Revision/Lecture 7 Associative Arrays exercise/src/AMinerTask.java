import java.util.*;
        import java.util.stream.Collectors;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputList = new ArrayList<>();
        String input = "";
        Map<String, Integer> products = new LinkedHashMap<>();
        while(!"stop".equals(input= scanner.nextLine())){
            String product = input;
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!products.containsKey(product)){
                products.put(product,quantity);
            }
            else{
                products.put(product,products.get(product)+quantity);
            }
        }
        products.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
