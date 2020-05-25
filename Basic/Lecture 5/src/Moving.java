import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        int space = width*length*height;
        int counter=0;
        String a =scanner.nextLine();
        while(!a.equalsIgnoreCase("Done")){
            int number=Integer.parseInt(a);
            counter+=number;
            if(counter>=space){
                break;
            }
            a=scanner.nextLine();
        }
        if(counter>=space){
            int dif=counter-space;
            System.out.printf("No more free space! You need %d Cubic meters more.",dif);
        }
        else {
            int dif=space-counter;
            System.out.printf("%d Cubic meters left.",dif);
        }
    }
}
