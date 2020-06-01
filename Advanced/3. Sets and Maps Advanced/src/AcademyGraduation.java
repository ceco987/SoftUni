import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map <String, Double> output = new TreeMap<>();
        while (n-->0){
            String student = scanner.nextLine();
            double[]grades = Arrays.stream(scanner.nextLine().split("\\s+"))
            .mapToDouble(Double::parseDouble).toArray();
            double sum = 0;
            for (double num : grades) {
                sum+=num;
            }
            double result = sum/grades.length;
            output.put(student,result);
        }
        for (Map.Entry<String, Double> entry : output.entrySet()) {
            System.out.printf("%s is graduated with ",entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
