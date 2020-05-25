import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map <String,Double> finished = new LinkedHashMap<>();
        Map <String,Integer> couple = new LinkedHashMap<>();
        String input ="";
        while(!"buy".equals(input=scanner.nextLine())){
            String[]commands = input.split(" ");
            String name = commands[0];
            double price = Double.parseDouble(commands[1]);
            int quantity = Integer.parseInt(commands[2]);
            if (!finished.containsKey(name)) {
                finished.put(name, price*quantity);
                couple.put(name, quantity);
            }
            else {
                couple.put(name,couple.get(name)+quantity);
                finished.put(name,couple.get(name)*price);
            }
        }
        finished.forEach((key,value)-> System.out.println(String.format("%s -> %.2f",key,value)));
    }
}
