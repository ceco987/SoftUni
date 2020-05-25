import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Gauss_Trick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> num = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int size = num.size();
        for (int i = 0; i < size/2; i++) {
            num.set(i,(num.get(i)+num.get(num.size()-1)));
            num.remove(num.get(num.size()-1));
        }
        System.out.println(num.toString().replaceAll("\\]|,|\\[",""));
    }
}
