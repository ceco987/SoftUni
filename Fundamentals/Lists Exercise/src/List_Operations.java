import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class List_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        while (true) {
            String[] command = scanner.nextLine().split("\\s+");
            if(command[0].equals("End")) break;
            switch (command[0]){
                case "Add":
                    nums.add(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    if(Integer.parseInt(command[2])>=nums.size()) {
                        System.out.println("Invalid index");
                        continue;
                    }
                    nums.add(Integer.parseInt(command[2]),Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    if(Integer.parseInt(command[1])>=nums.size()) {
                        System.out.println("Invalid index");
                        continue;
                    }
                    else nums.remove(Integer.parseInt(command[1]));
                    break;
                case "Shift":
                    shift(nums,command);
                    break;
            }
        }
        System.out.println(nums.toString().replaceAll("[\\[\\],]",""));
    }

    static void shift(List<Integer> list,String[] cmd){
        String direction = cmd[1];
        int count = Integer.parseInt(cmd[2]);
        int value=-1;
        if(direction.equals("left")) {
            for (int i = 0; i < count; i++) {
                value = list.get(0);
                list.remove(0);
                list.add(value);
            }
        }
        else {
            for (int i = 0; i < count; i++) {
                value = list.get(list.size()-1);
                list.remove(list.size()-1);
                list.add(0,value);
            }
        }
    }
}