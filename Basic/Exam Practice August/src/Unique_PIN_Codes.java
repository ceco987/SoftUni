import java.util.Scanner;

public class Unique_PIN_Codes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=first ; i++) {
            if(i%2!=0) continue;
            for (int j = 1; j <=second; j++) {
                if(j==1||j==4||j==6||j==8||j==9) continue;
                for (int k = 1; k <=third ; k++) {
                    if(k%2!=0) continue;
                    System.out.println(i+" "+j+" "+k);
                }
            }
        }
    }
}
