import java.util.Scanner;

public class Max_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int num=0;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=a;i++){
            num=Integer.parseInt(scanner.nextLine());
            if(num>max) max=num;
        }
        System.out.println(max);
    }
}
