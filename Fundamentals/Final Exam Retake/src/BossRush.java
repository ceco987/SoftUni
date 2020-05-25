import java.util.Arrays;
import java.util.Scanner;

public class BossRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String error = "Access denied!";
        while(n-->0){
            boolean isError=false;
            String[]input = Arrays.stream(scanner.nextLine().split("\\|+|#+|:")).filter(e->!e.equals("")).toArray(String[]::new);
            if(input[0].matches("\\b[A-Z]+\\b")&&input[0].length()>=4&&
                    input[1].matches("^([a-zA-Z])+([\\s])([a-zA-Z])+$")){
                System.out.println(String.format("%s, The %s",input[0],input[1]));
                System.out.println(String.format(">> Strength: %d\n>> Armour: %d",input[0].length(),input[1].length()));
            }
            else System.out.println(error);
        }
    }
}
