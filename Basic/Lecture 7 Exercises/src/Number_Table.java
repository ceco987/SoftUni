import java.util.Scanner;

public class Number_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count=i+j+1;
                if(count>n) count=2*n-count;
                System.out.print(count+" ");
            }
            System.out.println();
        }
    }
}