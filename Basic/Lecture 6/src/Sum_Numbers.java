import java.util.Scanner;

public class Sum_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int sum=0;
        int num=0;
        for(int i=1;i<=a;i++){
            num=Integer.parseInt(scanner.nextLine());
            sum+=num;
        }
        System.out.println(sum);
    }
}
