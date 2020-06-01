import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> earth = new LinkedHashMap<>();
        while(n-->0){
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            earth.putIfAbsent(continent,new LinkedHashMap<>());
            earth.get(continent).putIfAbsent(country,new ArrayList<>());
            earth.get(continent).get(country).add(city);
        }
        for (Map.Entry<String, Map<String, List<String>>> entry : earth.entrySet()) {
            printAll(entry);
        }
    }

    private static void printAll(Map.Entry<String, Map<String, List<String>>> entry) {
        System.out.println(entry.getKey()+":");
        entry.getValue().entrySet().stream().forEach(e->{
            String temp = e.getValue().toString().replaceAll("[\\[\\]]","");
            System.out.println("  "+e.getKey()+" -> " + temp);
        });
    }
}
