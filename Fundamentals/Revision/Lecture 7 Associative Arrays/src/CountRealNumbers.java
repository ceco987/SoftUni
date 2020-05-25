import java.text.DecimalFormat;
import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToDouble(Double::parseDouble).toArray();
        TreeMap<Double,Integer> someMap = new TreeMap<>();
        for (double num : nums) {
            if (!someMap.containsKey(num)){
                someMap.put(num,0);
            }
            someMap.put(num,someMap.get(num)+1);
        }
        DecimalFormat df = new DecimalFormat("#.######");
        for (Map.Entry<Double, Integer> entry : someMap.entrySet()) {
            System.out.printf("%s -> %d\n",df.format(entry.getKey()),entry.getValue());
        }
    }
}
