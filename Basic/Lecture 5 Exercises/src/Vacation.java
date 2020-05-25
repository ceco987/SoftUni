import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vacationAmount = Double.parseDouble(scanner.nextLine());
        double currentAmount = Double.parseDouble(scanner.nextLine());
        double amount=0;
        int count=0;
        int days=0;
        String action="";
        while(true){
            action = scanner.nextLine();
            amount = Double.parseDouble(scanner.nextLine());
            switch(action){
                case "save":
                currentAmount+=amount;
                count=0;
                break;
                case "spend":
                    currentAmount-=amount;
                    count++;
                    break;
            }
            days++;
            if(count<=0) count=0;
            else if(count==5)
            {
                System.out.printf("You can't save the money.\n%d",days);
                break;
            }
            if(currentAmount<0) currentAmount=0;
            else if(currentAmount>=vacationAmount){
                System.out.printf("You saved the money for %d days.",days);
                break;
            }
        }
    }
}
