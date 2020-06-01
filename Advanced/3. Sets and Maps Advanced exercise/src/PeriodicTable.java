import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> output = new TreeSet<>();
        while(n-->0){
            String[] input = scanner.nextLine().split("\\s+");
            output.addAll(Arrays.asList(input));
        }
        for (String s : output) {
            System.out.print(s+" ");
        }
    }
}
