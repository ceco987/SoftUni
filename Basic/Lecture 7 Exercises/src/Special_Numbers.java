import java.util.Scanner;

public class Special_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1111; i <=9999 ; i++) {
            String a = String.valueOf(i);
            if(a.charAt(0)=='0'||a.charAt(1)=='0'||a.charAt(2)=='0'||a.charAt(3)=='0') continue;
            if(n%Integer.parseInt(String.valueOf(a.charAt(0)))==0&&n%Integer.parseInt(String.valueOf(a.charAt(1)))==0&&n%Integer.parseInt(String.valueOf(a.charAt(2)))==0&&n%Integer.parseInt(String.valueOf(a.charAt(3)))==0)
                System.out.printf("%d ",i);
        }
    }
}
