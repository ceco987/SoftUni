import java.util.Scanner;

public class Multiplication_Table_Updated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int a = Integer.parseInt(scanner.nextLine());
        if(a>10) System.out.printf("%d X %d = %d",n,a,n*a);
        else for (int i = a; i <=10 ; i++) {
            System.out.printf("%d X %d = %d\n",n,i,n*i);
        }
    }
}
