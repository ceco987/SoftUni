import java.util.Scanner;

public class Own_Business {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());
        int area=w*l*h;
        String a ="";
        int comp = 0;
        while(area>=0){
            a=scanner.nextLine();
            if(a.equals("Done")) {
                System.out.printf("%d Cubic meters left.",area);
                return;
            }
            comp=Integer.parseInt(a);
            area-=comp;
        }
        System.out.printf("No more free space! You need %d Cubic meters more.",Math.abs(area));
    }
}
