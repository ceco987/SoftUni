import java.util.Scanner;

public class Fruit_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a=scanner.nextLine();
        String day=scanner.nextLine();
        double quant=Double.parseDouble(scanner.nextLine());
        if(a.equals("banana")){
            if(day.equals("Monday")||day.equals("Tuesday")||day.equals("Wednesday")||day.equals("Thursday")||day.equals("Friday"))
                System.out.println(quant*2.5);
            else if(day.equals("Saturday")||day.equals("Sunday")) System.out.println(quant*2.7);
            else System.out.println("error");
        }
        else if(a.equals("apple")){
            if(day.equals("Monday")||day.equals("Tuesday")||day.equals("Wednesday")||day.equals("Thursday")||day.equals("Friday"))
                System.out.println(quant*1.2);
            else if(day.equals("Saturday")||day.equals("Sunday")) System.out.println(quant*1.25);
            else System.out.println("error");
        }
        else if(a.equals("orange")){
            if(day.equals("Monday")||day.equals("Tuesday")||day.equals("Wednesday")||day.equals("Thursday")||day.equals("Friday"))
                System.out.println(quant*0.85);
            else if(day.equals("Saturday")||day.equals("Sunday")) System.out.println(quant*0.9);
            else System.out.println("error");
        }
        else if(a.equals("grapefruit")){
            if(day.equals("Monday")||day.equals("Tuesday")||day.equals("Wednesday")||day.equals("Thursday")||day.equals("Friday"))
                System.out.println(quant*1.45);
            else if(day.equals("Saturday")||day.equals("Sunday")) System.out.println(quant*1.6);
            else System.out.println("error");
        }
        else if(a.equals("kiwi")){
            if(day.equals("Monday")||day.equals("Tuesday")||day.equals("Wednesday")||day.equals("Thursday")||day.equals("Friday"))
                System.out.println(quant*2.7);
            else if(day.equals("Saturday")||day.equals("Sunday")) System.out.println(quant*3);
            else System.out.println("error");
        }
        else if(a.equals("pineapple")){
            if(day.equals("Monday")||day.equals("Tuesday")||day.equals("Wednesday")||day.equals("Thursday")||day.equals("Friday"))
                System.out.println(quant*5.5);
            else if(day.equals("Saturday")||day.equals("Sunday")) System.out.println(quant*5.6);
            else System.out.println("error");
        }
        else if(a.equals("grapes")){
            if(day.equals("Monday")||day.equals("Tuesday")||day.equals("Wednesday")||day.equals("Thursday")||day.equals("Friday"))
                System.out.println(quant*3.85);
            else if(day.equals("Saturday")||day.equals("Sunday")) System.out.println(quant*4.2);
            else System.out.println("error");
        }
        else System.out.println("error");
    }
}
