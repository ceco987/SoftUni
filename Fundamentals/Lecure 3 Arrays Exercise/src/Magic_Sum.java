import java.util.Arrays;
import java.util.Scanner;

public class Magic_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int []a = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < a.length; i++) {
            for (int j=i+1; j < a.length; j++) {
                if(a[i]+a[j]==num){
                    System.out.println(a[i]+" "+a[j]);
                }
            }
        }
    }
}
