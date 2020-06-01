import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < dimensions[0]; i++) {
            firstSet.add(scanner.nextLine());
        }
        for (int i = 0; i < dimensions[1]; i++) {
            secondSet.add(scanner.nextLine());
        }
        firstSet.retainAll(secondSet);
        firstSet.forEach(e-> System.out.print(e+" "));
    }
}
