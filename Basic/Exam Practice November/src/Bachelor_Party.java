import java.util.Scanner;

public class Bachelor_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chalga = Integer.parseInt(scanner.nextLine());
        String a = "";
        int people=0;
        int price=0;
        int count=0;
        while(true){
            a = scanner.nextLine();
            if(a.equals("The restaurant is full")) break;
            else{
                people=Integer.parseInt(a);
                count+=people;
                if(people<5) price+=people*100;
                else price+=people*70;
            }
        }
        int diff=price-chalga;
        if(price>=chalga) System.out.printf("You have %d guests and %d leva left.",count,diff);
        else System.out.printf("You have %d guests and %d leva income, but no singer.",count, price);
    }
}
