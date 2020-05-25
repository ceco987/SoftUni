import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] a = new String[n];
        String[] b = new String[n];

        for (int i = 0; i <n; i++) {
            if(i%2==0){
                String [] input = scanner.nextLine().split(" ");
                a[i] = input[0];
                b[i] = input[1];

            }
            else {
                String [] input = scanner.nextLine().split(" ");
                b[i] = input[0];
                a[i] = input[1];

            }
        }
        System.out.println(String.join(" ",a));
        System.out.println(String.join(" ",b));
    }
}
