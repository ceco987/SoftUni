import java.util.Scanner;

public class Divide_Without_Remainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int p1=0;
        int p2=0;
        int p3=0;
        for (int i = 0; i <n ; i++) {
            int a = Integer.parseInt(scanner.nextLine());
            if(a%2==0) p1++;
            if(a%3==0) p2++;
            if(a%4==0) p3++;
        }
        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n",(double)p1/n*100,(double)p2/n*100,(double)p3/n*100);
    }
}
