import java.util.*;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer>first= Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer>second= Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toList());
        while(first.size()>0&&second.size()>0) {
            if (first.get(0)>second.get(0)){
                Collections.rotate(first,-1);
                first.add(second.get(0));
                second.remove(0);
            }
            else if (second.get(0)>first.get(0)){
                Collections.rotate(second,-1);
                second.add(first.get(0));
                first.remove(0);
            }
            else if (first.get(0)==second.get(0)){
                first.remove(0);
                second.remove(0);
            }
        }
        if (first.size()>0){
            System.out.printf("First player wins! Sum: %d",first.stream().mapToInt(Integer::intValue).sum());
        }
        else if (second.size()>0){
            System.out.printf("Second player wins! Sum: %d",second.stream().mapToInt(Integer::intValue).sum());
        }
    }
}
