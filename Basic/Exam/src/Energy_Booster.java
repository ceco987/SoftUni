import java.util.Scanner;

public class Energy_Booster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int amount = Integer.parseInt(scanner.nextLine());
        double price=0;
        double total=0;
        switch(size){
            case "small":
                price=2;
                switch(fruit){
                    case "Watermelon":
                        price*=56;
                        break;
                    case "Mango":
                        price*=36.66;
                        break;
                    case "Pineapple":
                        price*=42.10;
                        break;
                    case "Raspberry":
                        price*=20;
                        break;
                }
                break;
            case "big":
                price=5;
                switch(fruit){
                    case "Watermelon":
                        price*=28.70;
                        break;
                    case "Mango":
                        price*=19.60;
                        break;
                    case "Pineapple":
                        price*=24.80;
                        break;
                    case "Raspberry":
                        price*=15.20;
                        break;
                }
                break;
        }
        total=amount*price;
        if(total>=400&&total<=1000) total*=0.85;
        else if(total>1000) total*=0.5;
        System.out.printf("%.2f lv.",total);
    }
}
