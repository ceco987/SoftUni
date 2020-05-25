import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> output = new ArrayDeque<>();

        if (number==0) {
            System.out.print("0");
            return;
        }
        while(number>0){
            output.push(number%2);
            number/=2;
        }
        for (Integer digit : output) {
            System.out.print(digit);
        }

    }
}
