import java.util.Scanner;

public class Back_in_Thirty_Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int newMinutes=minutes+30;
        if(newMinutes>=60) {
            newMinutes-=60;
            if(hours==23) hours=0;
            else hours+=1;
        }
        System.out.printf("%d:%02d",hours,newMinutes);
    }
}
