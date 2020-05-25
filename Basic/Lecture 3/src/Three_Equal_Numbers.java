import java.util.Scanner;

public class Three_Equal_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        if (a==b){
            if(a==c){
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
        else System.out.println("no");
    }
}
