import java.util.Scanner;

public class RecursiveFibonacci {

    public static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        memory = new long[n+1];
        System.out.println(fibonnaci(n));

    }

    private static long fibonnaci(int n) {
        if (n<=1) {
            return 1;
        }

        if (memory[n]!=0){
            return memory[n];
        }

        return memory[n]=fibonnaci(n-1) + fibonnaci(n-2);
    }
}
