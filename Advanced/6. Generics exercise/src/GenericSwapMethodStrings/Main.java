package GenericSwapMethodStrings;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<Integer>> boxList = new ArrayList<>();
        while (n-->0){
            Box<Integer> newBox = new Box<>(Integer.parseInt(scanner.nextLine()));
            boxList.add(newBox);
        }
        int[]swapIndices = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        swapValues(boxList, swapIndices);
        for (Box<Integer> stringBox : boxList) {
            System.out.println(stringBox);
        }
    }

    private static <T> void swapValues(List<Box<T>> boxList, int[] swapIndices) {
        Collections.swap(boxList, swapIndices[0], swapIndices[1]);
    }
}
