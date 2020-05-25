import java.util.Scanner;

public class Min_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a=Integer.parseInt(scanner.nextLine());
        int num=0;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <a ; i++) {
            num=Integer.parseInt(scanner.nextLine());
            if(num<min) min=num;
        }
        System.out.println(min);
    }
}
