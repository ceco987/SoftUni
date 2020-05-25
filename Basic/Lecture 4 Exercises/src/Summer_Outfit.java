import java.util.Scanner;

public class Summer_Outfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int g = Integer.parseInt(scanner.nextLine());
        String a = scanner.nextLine();
        String outfit = " ";
        String shoes = " ";
        if (g >= 10 && g <= 18) {
            switch (a) {
                case "Morning":
                    outfit = "Sweatshirt";
                    shoes = "Sneakers";
                    break;
                case "Afternoon":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
            }
        } else if (g > 18 && g <= 24) {
            switch (a) {
                case "Morning":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                case "Afternoon":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
            }
        } else if (g >= 25) {
            switch (a) {
                case "Morning":
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;
                case "Afternoon":
                    outfit = "Swim Suit";
                    shoes = "Barefoot";
                    break;
                case "Evening":
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
            }
        }
        System.out.printf("It's %d degrees, get your %s and %s.", g, outfit, shoes);
    }
}
