import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> record = new TreeMap<>();
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            record.putIfAbsent(name,new ArrayList<>());
            record.get(name).add(grade);
        }
        for (Map.Entry<String, List<Double>> entry : record.entrySet()) {
            System.out.printf("%s -> %s (avg: %.2f)%n",entry.getKey(),
                    printGrades(entry.getValue()),
                    getAverage(entry.getValue()));
        }
    }

    private static double getAverage(List<Double> value) {
        return value.stream().mapToDouble(e -> e/value.size()).sum();
    }

    private static String printGrades(List<Double> list) {
    return list.stream().map(e-> String.format("%.2f",e))
            .collect(Collectors.joining(" "));
    }
}
