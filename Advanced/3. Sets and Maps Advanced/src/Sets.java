import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Set <String> parking = new LinkedHashSet<>();
        while(!"END".equals(input = scanner.nextLine())) {
            String direction = input.substring(0, input.indexOf(','));
            String registration = input.substring(input.indexOf(' ') + 1);
            if (direction.equals("IN")){
                parking.add(registration);
            }
            else parking.remove(registration);
        }
        if (parking.isEmpty()) System.out.println("Parking Lot is Empty");
        for (String s : parking) {
            System.out.println(s);
        }
    }
}
