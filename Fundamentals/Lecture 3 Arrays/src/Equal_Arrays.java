import java.util.Arrays;
import java.util.Scanner;

public class Equal_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] firstNumber = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] secondNumber = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index=-1, sum=0;
        for (int i = 0; i < firstNumber.length; i++) {
            if(firstNumber[i]!=secondNumber[i]){
                index=i; break;
            }
            sum+=firstNumber[i];
        }

        if(index==-1)
            System.out.println("Arrays are identical. Sum: " + sum);

        else System.out.println("Arrays are not identical. Found difference at "+index+" index.");
    }
}
