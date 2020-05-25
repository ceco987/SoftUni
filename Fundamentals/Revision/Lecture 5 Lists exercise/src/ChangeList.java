import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                     .collect(Collectors.toList());
        String command = scanner.nextLine();
        while(!"end".equals(command)){
            String[]operation = command.split("\\s+");
            if (operation[0].equals("Delete")){
               input.removeIf(e->e.equals(operation[1]));
            }
            else if (Integer.parseInt(operation[2])>=0&&Integer.parseInt(operation[2])<input.size()){
                String element = operation [1];
                int position = Integer.parseInt(operation[2]);
                input.add(position,element);
            }
            command = scanner.nextLine();
        }
        System.out.println(input.toString().replaceAll("[\\[\\],]", ""));
    }
}
