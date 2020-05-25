import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Change_List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        while(true){
           String[] command=scanner.nextLine().split("\\s+");
           if(command[0].equals("end")) break;
           switch(command[0]){
               case "Delete":
                   if(!list.contains(Integer.parseInt(command[1]))) continue;
                   list.removeIf(e->e==Integer.parseInt(command[1]));
                   break;
               case "Insert":
                   list.add(Integer.parseInt(command[2]),Integer.parseInt(command[1]));
                   break;
           }
        }
        System.out.println(list.toString().replaceAll("[\\[\\],]",""));
    }
}
