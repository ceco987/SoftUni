import java.util.Scanner;

public class Safe_Passwords_Generator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int limit = Integer.parseInt(scanner.nextLine());
        boolean end = false;
        int count=0;
        for (char i = 35; i <=55 ; ) {
            for (char j = 64; j <=96 ; ) {
                for (int k = 1; k <=a ;k++) {
                    for (int l = 1; l <=b ;l++) {
                        System.out.printf("%c%c%d%d%c%c|",i,j,k,l,j,i);
                        count++;
                        if(count>=limit||(k==a&&l==b)) {
                            end=true;
                            break;
                        }
                        i++;
                        j++;
                        if(i>55) i=35;
                        if(j>96) j=64;
                    }
                    if(end) break;
                }
                if(end) break;
            }
            if(end) break;
        }
    }
}
