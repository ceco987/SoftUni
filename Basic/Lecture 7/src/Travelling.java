import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();
        if(destination.equals("End")) return;
        double budget=Double.parseDouble(scanner.nextLine());
        double salary=Double.parseDouble(scanner.nextLine());
        double sum=0;
        while(true){
            sum+=salary;
            if(sum<budget) salary=Double.parseDouble(scanner.nextLine());
            else {
                System.out.printf("Going to %s!\n",destination);
                sum=0;
                destination=scanner.nextLine();
                if(destination.equals("End")) return;
                budget=Double.parseDouble(scanner.nextLine());
                salary=Double.parseDouble(scanner.nextLine());
            }
        }
    }
}