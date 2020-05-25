import java.util.Scanner;

public class Ticket_Combination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int count=0;
        for (int i = (int)'B'; i <=(int)'L' ; i++) {
            if(i%2==0){
                for (int j = (int)'f'; j >=(int)'a' ; j--) {
                    for (int k = (int)'A'; k <=(int)'C' ; k++) {
                        for (int l = 1; l <=10 ; l++) {
                            for (int m = 10; m >=1 ; m--) {
                                count++;
                                if(count==num) {
                                    System.out.printf("Ticket combination: %c%c%c%d%d\n",(char)i,(char)j,(char)k,l,m);
                                    System.out.printf("Prize: %d lv.",i+j+k+l+m);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
