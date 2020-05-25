import java.util.Scanner;

public class Vending_Machine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        double sum=0;
        while(!command.equals("Start")){
            if(Double.parseDouble(command)==0.1||
                    Double.parseDouble(command)==0.2||
                    Double.parseDouble(command)==0.5||
                    Double.parseDouble(command)==1||
                    Double.parseDouble(command)==2)
                sum+=Double.parseDouble(command);
            else System.out.printf("Cannot accept %.2f%n",Double.parseDouble(command));
            command = scanner.nextLine();
        }
        double cost=0;
        String product = scanner.nextLine();
        while(!product.equals("End")){
            switch(product){
                default:
                    System.out.println("Invalid product");
                    break;
                case "Nuts":
                    cost=2;
                    if(cost>sum){
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    else{
                        sum-=cost;
                        System.out.println("Purchased "+product);
                    }
                    break;
                case "Water":
                    cost=0.7;
                    if(cost>sum){
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    else{
                        sum-=cost;
                        System.out.println("Purchased "+product);
                    }
                    break;
                case "Crisps":
                    cost=1.5;
                    if(cost>sum){
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    else{
                        sum-=cost;
                        System.out.println("Purchased "+product);
                    }
                    break;
                case "Soda":
                    cost=0.8;
                    if(cost>sum){
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    else{
                        sum-=cost;
                        System.out.println("Purchased "+product);
                    }
                    break;
                case "Coke":
                    cost=1;
                    if(cost>sum){
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    else{
                        sum-=cost;
                        System.out.println("Purchased "+product);
                    }
                    break;
            }
            product=scanner.nextLine();
        }
        System.out.printf("Change: %.2f",sum);
    }
}
