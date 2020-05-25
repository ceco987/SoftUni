import java.util.Scanner;

public class Number_Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        while (true) {
           String a=scanner.nextLine();
            if(a.equalsIgnoreCase("end")) break;
            num=Integer.parseInt(a);
            if(num<min) min=num;
            if(num>max) max=num;
        }
        System.out.printf("Max number: %d%nMin number: %d",max,min);
    }
}
