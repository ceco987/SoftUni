import java.util.Scanner;

public class Fishing_Boat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fisherman = Integer.parseInt(scanner.nextLine());
        double seasonal=0;
        double rent=0;
        double ost=0;
        switch(season){
            case "Spring":
                seasonal=3000;
                break;
            case "Summer":
            case "Autumn":
                seasonal=4200;
                break;
            case "Winter":
                seasonal=2600;
        }
        if(fisherman<=6)
            rent=seasonal*0.9;
        else if(fisherman<=11)
            rent=seasonal*0.85;
        else rent=seasonal*0.75;
        if(fisherman%2==0&&(season.equals("Summer")||season.equals("Spring")||season.equals("Winter")))
        rent=rent*0.95;
        ost=Math.abs(rent-budget);
        if (rent<=budget) System.out.printf("Yes! You have %.2f leva left.",ost);
        else System.out.printf("Not enough money! You need %.2f leva.",ost);
    }
}
