import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        while(true){
            String[] line = scanner.nextLine().split(" ");
            if(line[0].equals("end")){
                break;
            }
            switch(line[0]){
                case "Add":
                    wagons.add(Integer.parseInt(line[1]));
                    break;
                default:
                    int number=Integer.parseInt(line[0]);
                    for (int i = 0; i < wagons.size(); i++) {
                        if(maxCapacity-(wagons.get(i)+number)>=0){
                            wagons.set(i,wagons.get(i)+number);
                            break;
                        }
                    }
            }
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]",""));
    }
}
