import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> legendaries = new LinkedHashMap<>(){{
            put("shards",0);
            put("fragments",0);
            put("motes",0);
        }};
        Map<String,Integer> junks = new TreeMap<>();
        boolean flag=false;
        do {
            String[] input = scanner.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i += 2) {
                String material = input[i + 1].toLowerCase();
                int quantity = Integer.parseInt(input[i]);
                if (!legendaries.containsKey(material)) {
                    if (!junks.containsKey(material)) {
                        junks.put(material, quantity);
                    } else junks.put(material, junks.get(material) + quantity);
                } else {
                    legendaries.put(material, legendaries.get(material)+quantity);
                    if (legendaries.get(material) >= 250) {
                        legendaries.put(material,legendaries.get(material)-250);
                        switch(material){
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }
                        flag = true;
                        break;
                    }
                }
            }
        } while (!flag);
        legendaries.entrySet().stream()
                .sorted((a,b)->{
                    int n = b.getValue().compareTo(a.getValue());
                    if (n==0){
                        return a.getKey().compareTo(b.getKey());
                    }
                    else return n;

        }).forEach(e-> System.out.println(String.format("%s: %d",e.getKey(),e.getValue())));
        junks.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
