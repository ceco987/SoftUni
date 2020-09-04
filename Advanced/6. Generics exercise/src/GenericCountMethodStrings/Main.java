package GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxList = new ArrayList<>();
        while (n-- > 0) {
            boxList.add(new Box<>(scanner.nextLine()));
        }
        String compared = scanner.nextLine();
        System.out.print(countMethod(boxList, compared));
    }

    public static <T extends Comparable<T>> int countMethod(List<Box<T>> boxList, T compared){
        int count = 0;
        for (Box<T> t : boxList) {
            if (t.compareTo(compared) > 0) count++;
        }
        return count;
    }
}
