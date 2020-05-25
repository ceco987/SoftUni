import java.util.Scanner;

public class Sushi_Time {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sushi = scanner.nextLine();
        String restaurant = scanner.nextLine();
        int portions = Integer.parseInt(scanner.nextLine());
        String order = scanner.nextLine();
        double sushiPrice=0;
        double total=0;
        switch(restaurant){
            case "Sushi Zone":
                switch (sushi){
                    case "sashimi":
                        sushiPrice=4.99;
                        break;
                    case "maki":
                        sushiPrice=5.29;
                        break;
                    case "uramaki":
                        sushiPrice=5.99;
                        break;
                    case "temaki":
                        sushiPrice=4.29;
                        break;
                }
                break;
            case "Sushi Time":
                switch (sushi){
                    case "sashimi":
                        sushiPrice=5.49;
                        break;
                    case "maki":
                        sushiPrice=4.69;
                        break;
                    case "uramaki":
                        sushiPrice=4.49;
                        break;
                    case "temaki":
                        sushiPrice=5.19;
                        break;
                }
                break;
            case "Sushi Bar":
                switch (sushi){
                    case "sashimi":
                        sushiPrice=5.25;
                        break;
                    case "maki":
                        sushiPrice=5.55;
                        break;
                    case "uramaki":
                        sushiPrice=6.25;
                        break;
                    case "temaki":
                        sushiPrice=4.75;
                        break;
                }
                break;
            case "Asian Pub":
                switch (sushi){
                    case "sashimi":
                        sushiPrice=4.50;
                        break;
                    case "maki":
                        sushiPrice=4.80;
                        break;
                    case "uramaki":
                        sushiPrice=5.50;
                        break;
                    case "temaki":
                        sushiPrice=5.50;
                        break;
                }
                break;
            default:
                System.out.printf("%s is invalid restaurant!",restaurant);
                return;
        }
        total=portions*sushiPrice;
        if(order.equals("Y")) total*=1.2;
        System.out.printf("Total price: %.0f lv.",Math.ceil(total));
    }
}
