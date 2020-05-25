import java.util.Scanner;

public class Spring_Vacation_Trip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int group = Integer.parseInt(scanner.nextLine());
        double mileage = Double.parseDouble(scanner.nextLine());
        double foodExpanses = Double.parseDouble(scanner.nextLine());
        double pricePerNight = Double.parseDouble(scanner.nextLine());

        double distanceCost=0;

        if(group>10) pricePerNight*=0.75;
        double foodCost=foodExpanses*group*days;
        double sleepingCost=pricePerNight*group*days;
        double currentExpanses=foodCost+sleepingCost;

        for (int i = 0; i < days; i++) {
            double distance=Double.parseDouble(scanner.nextLine());
            distanceCost=distance*mileage;
            currentExpanses+=distanceCost;
            if((i+1)%3==0||(i+1)%5==0){
                currentExpanses*=1.4;
            }
            if((i+1)%7==0){
                currentExpanses=currentExpanses-(currentExpanses/group);
            }
        }
        if(currentExpanses>budget){
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more. ",currentExpanses-budget);
        }
        else System.out.printf("You have reached the destination. You have %.2f$ budget left.",budget-currentExpanses);
    }
}
