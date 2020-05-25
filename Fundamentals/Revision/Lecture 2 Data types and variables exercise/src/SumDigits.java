import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int sum=0;
        while(a!=0){
            sum+=a%10;
            a/=10;
        }
        System.out.println(sum);
    }
}
