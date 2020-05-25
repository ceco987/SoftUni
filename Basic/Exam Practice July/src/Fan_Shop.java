import java.util.Scanner;

public class Fan_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        int price =0;
        for (int i = 0; i <n ; i++) {
            String type = scanner.nextLine();
            switch (type){
                case "hoodie":
                    price+=30;
                    break;
                case "keychain":
                    price+=4;
                    break;
                case "T-shirt":
                    price+=20;
                    break;
                case "flag":
                    price+=15;
                    break;
                case "sticker":
                    price+=1;
                    break;
            }
        }
        if(budget>=price) System.out.printf("You bought %d items and left with %d lv.",n,budget-price);
        else System.out.printf("Not enough money, you need %d more lv.",price-budget);
    }
}
