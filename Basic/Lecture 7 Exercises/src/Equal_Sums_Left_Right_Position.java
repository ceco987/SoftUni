import java.util.Scanner;

public class Equal_Sums_Left_Right_Position {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        for (int i = a; i <=b ; i++) {
            String num=String.valueOf(i);
            int sumLeft=Integer.parseInt(String.valueOf(num.charAt(0)))+Integer.parseInt(String.valueOf(num.charAt(1)));
            int sumRight=Integer.parseInt(String.valueOf(num.charAt(3)))+Integer.parseInt(String.valueOf(num.charAt(4)));
            if(sumLeft==sumRight) System.out.print(i+" ");
            else if(Math.abs(sumLeft-sumRight)-Integer.parseInt(String.valueOf(num.charAt(2)))==0){
                System.out.print(i+" ");
            }
        }
    }
}
