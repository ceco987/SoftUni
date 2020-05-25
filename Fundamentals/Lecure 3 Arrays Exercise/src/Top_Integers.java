import java.util.Arrays;
import java.util.Scanner;

public class Top_Integers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < arr.length; i++) {
            boolean yes = true;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]<=arr[j]){
                    yes = false;
                    break;
                }
            }
            if (yes) System.out.print(arr[i]+" ");
        }

    }
}
