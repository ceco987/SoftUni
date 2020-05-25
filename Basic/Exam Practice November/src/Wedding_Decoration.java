import java.util.Scanner;

public class Wedding_Decoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initialBudget = Double.parseDouble(scanner.nextLine());
        double budget=initialBudget;
        double sum=0;
        String type="";
        int count=0;
        double spent=0;

        double balloonsPrice = 0.1;
        double flowersPrice = 1.5;
        double candlesPrice = 0.5;
        double ribbonPrice = 2;

        int balloonsCount = 0;
        int flowersCount = 0;
        int candlesCount = 0;
        int ribbonCount = 0;
        while(true){
            type=scanner.nextLine();
            if(type.equals("stop")){
                System.out.printf("Spend money: %.2f%n",sum);
                System.out.printf("Money left: %.2f%n", initialBudget-sum);
                break;
            }
            count=Integer.parseInt(scanner.nextLine());
            switch(type){
                case "balloons":
                    spent=count*balloonsPrice;
                    balloonsCount+=count;
                    break;
                case "flowers":
                    spent=count*flowersPrice;
                    flowersCount+=count;
                    break;
                case "candles":
                    spent=count*candlesPrice;
                    candlesCount+=count;
                    break;
                case "ribbon":
                    spent=count*ribbonPrice;
                    ribbonCount+=count;
                    break;
            }
            sum+=spent;
            budget-=spent;
            if(budget<=0){
                System.out.println("All money is spent!");
                break;
            }
        }
        System.out.printf("Purchased decoration is %d balloons, %d m ribbon, %d flowers and %d candles.",balloonsCount,ribbonCount,flowersCount,candlesCount);
    }
}
