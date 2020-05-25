import java.util.Scanner;

public class Challenge_the_Wedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int men=Integer.parseInt(scanner.nextLine());
        int women=Integer.parseInt(scanner.nextLine());
        int maxTables=Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= men; i++) {
            for (int j = 1; j <=women ; j++) {
                System.out.printf("(%d <-> %d) ",i,j);
                maxTables--;
                if(maxTables==0) return;
            }
        }
    }
}
