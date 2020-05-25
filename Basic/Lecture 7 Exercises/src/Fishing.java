import java.util.Scanner;

public class Fishing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quote=Integer.parseInt(scanner.nextLine());
        String name = scanner.nextLine();
        int count=0;
        int grandCount=0;
        double price=0;
        double budget=0;
        while(!name.equals("Stop")){
            double weight=Double.parseDouble(scanner.nextLine());
            count++;
            for (int i = 0; i <name.length() ; i++) {
                price+=(int)name.charAt(i);
            }
            if(count!=3) {
                budget-=price/weight;
                price=0;
            }
            else {
                budget+=price/weight;
                count=0;
                price=0;
            }
            grandCount++;
            if(grandCount==quote) {
                System.out.println("Lyubo fulfilled the quota!");
                break;
            }
            name=scanner.nextLine();
        }
        if(budget>0) System.out.printf("Lyubo's profit from %d fishes is %.2f leva.",grandCount,budget);
        else System.out.printf("Lyubo lost %.2f leva today.",Math.abs(budget));
    }
}
