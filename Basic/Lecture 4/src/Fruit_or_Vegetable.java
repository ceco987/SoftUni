import java.util.Scanner;

public class Fruit_or_Vegetable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a=scanner.nextLine();
        if(a.equals("banana")||a.equals("apple")||a.equals("kiwi")||a.equals("cherry")||a.equals("lemon")||a.equals("grapes"))
            System.out.println("fruit");
        else if (a.equals("tomato") || a.equals("cucumber") || a.equals("pepper") || a.equals("carrot"))
                System.out.println("vegetable");
            else System.out.println("unknown");

    }
}
