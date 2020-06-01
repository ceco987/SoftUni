import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Map<String, String> contacts = new HashMap<>();
        while(!"search".equals(input = scanner.nextLine())){
        String name = input.substring(0,input.indexOf('-'));
        String number = input.substring(input.indexOf('-')+1);
        contacts.put(name,number);
        }
        while (!"stop".equals(input=scanner.nextLine())){
            String output = contacts.get(input) == null ? "Contact " + input + " does not exist." : input +" -> "+contacts.get(input);
            System.out.println(output);
        }
    }
}
