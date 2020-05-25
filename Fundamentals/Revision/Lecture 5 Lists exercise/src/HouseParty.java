import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List <String> people = new ArrayList<>();
        while(n-->0){
            String[] input = scanner.nextLine().split("\\s+");
            if (input[2].equals("going!")){
                if (people.contains(input[0])) System.out.printf("%s is already in the list!\n",input[0]);
                else people.add(input[0]);
            }
            else {
                if(people.contains(input[0])) people.remove(input[0]);
                else System.out.printf("%s is not in the list!\n",input[0]);
            }

        }
        System.out.print(String.join("\n",people));
    }
}
