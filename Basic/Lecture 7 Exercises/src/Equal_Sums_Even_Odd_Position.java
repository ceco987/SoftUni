import java.util.Scanner;

public class Equal_Sums_Even_Odd_Position {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        for (int i = a; i <=b ; i++) {
            String num=String.valueOf(i);
            int even=Integer.parseInt(String.valueOf(num.charAt(0)))+Integer.parseInt(String.valueOf(num.charAt(2)))+Integer.parseInt(String.valueOf(num.charAt(4)));
            int odd=Integer.parseInt(String.valueOf(num.charAt(1)))+Integer.parseInt(String.valueOf(num.charAt(3)))+Integer.parseInt(String.valueOf(num.charAt(5)));
            if(even==odd) System.out.print(i+" ");
        }
    }
}
