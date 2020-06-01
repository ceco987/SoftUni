import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Map <String,Map<String,Double>> output = new TreeMap<>();
        while(!"Revision".equals(input = scanner.nextLine())){
            String[] batch = input.split(",\\s+");
            String store = batch[0];
            String product = batch[1];
            double price = Double.parseDouble(batch[2]);
            output.putIfAbsent(store,new LinkedHashMap<>());
            output.get(store).put(product, price);
        }
        for (Map.Entry<String, Map<String, Double>> entry : output.entrySet()) {
            printStroreEtc(entry);
        }
    }

    private static void printStroreEtc(Map.Entry<String, Map<String, Double>> entry) {
        System.out.println(entry.getKey()+"->");
        entry.getValue().entrySet().forEach(e->
        {
            System.out.printf("Product: %s, Price: %.1f%n",e.getKey(),e.getValue());
        });
    }
}
