import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = "";
        while (!"End".equals(input = scanner.nextLine())) {
            String[] command = input.split("\\s+");
            switch (command[0]){
                case "Add":
                    data.add(command[1]);
                    break;
                case "Insert":
                    String number=command[1];
                    int index = Integer.parseInt(command[2]);
                    if (index<0||index>=data.size()) System.out.println("Invalid index");
                    else data.add(index,number);
                    break;
                case "Remove":
                    if (Integer.parseInt(command[1])<0||Integer.parseInt(command[1])>=data.size())
                        System.out.println("Invalid index");
                    else data.remove(Integer.parseInt(command[1]));
                    break;
                case "Shift":
                    if (command[1].equals("left")){
                        Collections.rotate(data,-Integer.parseInt(command[2]));
                    }
                    else Collections.rotate(data,Integer.parseInt(command[2]));
                    break;
            }
        }
        System.out.println(data.toString().replaceAll("[\\[\\],]", ""));
    }
}
