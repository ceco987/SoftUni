import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> output = new LinkedHashSet<>();
        while (n-- > 0) {
            output.add(scanner.nextLine());
        }
        output.forEach(System.out::println);
    }
}
