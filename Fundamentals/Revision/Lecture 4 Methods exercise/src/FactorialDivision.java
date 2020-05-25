import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        divide(factorial(a),factorial(b));
    }

    static double factorial (int a){
        double result=1;
        for (int i = 1; i <=a ; i++) {
            result*=i;
        }

        return result;
    }

    static void divide(double a, double b){
        System.out.println(String.format("%.2f",a/b));
    }
}
