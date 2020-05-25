import java.util.Scanner;

public class Strong_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int fact = 1;
        int sum = 0;
        for (int i = 0; i <num.length(); i++) {
            int workNum=Integer.parseInt(String.valueOf(num.charAt(i)));
            for (int j = workNum; j >=1; j--) {
                fact*=j;
            }
            sum+=fact;
            fact=1;
        }
        if (sum==Integer.parseInt(num)) System.out.println("yes");
        else System.out.println("no");
    }
}
