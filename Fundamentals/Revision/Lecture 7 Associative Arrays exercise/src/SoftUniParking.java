import java.util.*;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Set<String>> database = new LinkedHashMap<>();
        while(n-->0){
            String[]input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String username = input[1];
            String plate = "";
            if (input.length==3) {
                plate = input[2];
            }
            switch(command){
                case "register":
                    if (database.containsKey(username)){
                        System.out.printf("ERROR: already registered with plate number %s\n",database.get(username).toString().replaceAll("[\\[\\]]",""));
                    }
                    else{
                        String finalPlate = plate;
                        database.put(username,new LinkedHashSet<>(){{add(finalPlate);}});
                        System.out.println(String.format("%s registered %s successfully",username,plate));
                    }
                    break;
                case "unregister":
                    if (!database.containsKey(username)){
                        System.out.println(String.format("ERROR: user %s not found",username));
                    }
                    else{
                        database.remove(username);
                        System.out.println(String.format("%s unregistered successfully",username));
                    }
                    break;
            }
        }
        database.forEach((key,value)-> System.out.println(String.format("%s => %s",key,value.toString().replaceAll("[\\[\\]]",""))));
    }
}
