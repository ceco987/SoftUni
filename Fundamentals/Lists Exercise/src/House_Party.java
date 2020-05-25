import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class House_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commands = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>();
        String[] cmd = new String[10];
        for (int i = 0; i < commands; i++) {
            cmd=scanner.nextLine().split("\\s+");
            switch(cmd[2]){
                case "going!":
                    if(!guests.contains(cmd[0])){
                        guests.add(cmd[0]);
                    }
                    else System.out.println(cmd[0]+" is already in the list!");
                    break;
                case "not":
                    if(guests.contains(cmd[0])){
                        guests.remove(cmd[0]);
                    }
                    else System.out.println(cmd[0]+" is not in the list!");
                    break;
            }
        }
        for (String a :
                guests) {
            System.out.println(a);
        }
    }
}
