import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());
        int area=w*h;
        String a="";
        int parche=0;
        while(area>=0){
            a=scanner.nextLine();
            if(a.equals("STOP")){
                System.out.printf("%d pieces are left.",area);
                return;
            }
            parche = Integer.parseInt(a);
            area-=parche;
        }
        System.out.printf("No more cake left! You need %d pieces more.",Math.abs(area));
    }
}