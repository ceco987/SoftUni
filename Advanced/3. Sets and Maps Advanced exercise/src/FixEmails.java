import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String name = "";
        int count = 0;
        Map<String,String> output = new LinkedHashMap<>();
        while (!"stop".equals(input = scanner.nextLine())) {
            if (count % 2 == 0) {
                name = input;
                count++;
            }
            else {
                if (input.substring(input.indexOf('.')+1).equals("us")||
                        input.substring(input.indexOf('.')+1).equals("uk")||
                        input.substring(input.indexOf('.')+1).equals("com")){
                    count++;
                    }
                else{
                    output.put(name,input);
                    count++;
                }
            }
        }
        System.out.println(output.entrySet()
                .stream()
                .map(e->e.getKey()+" -> "+e.getValue())
                .collect(Collectors.joining(System.lineSeparator())));
    }
}