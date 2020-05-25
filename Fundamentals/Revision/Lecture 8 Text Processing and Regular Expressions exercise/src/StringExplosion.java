import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
//        int chevronCount = 1;
        int power = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i)=='>'){
                power+=Integer.parseInt(String.valueOf(input.charAt(i+1)));
                for (int j = i+1; j <= i+power; j++) {
                    if (input.charAt(j)!='>'){
                        input.deleteCharAt(j);
                    }
                    else{
                        power+=Integer.parseInt(String.valueOf(input.charAt(j+1)));
                    }
                }
                power=0;
            }
        }
        System.out.println(input);
    }
}
