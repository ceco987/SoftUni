import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        String pass ="";
        for (int i = user.length()-1; i >=0; i--) {
            pass+=user.charAt(i);
        }
        int count = 0;
        while(count<4) {
            String enter = scanner.nextLine();
            if(!enter.equals(pass)){
                if(count==3) break;
                System.out.println("Incorrect password. Try again.");
            }
            else {
                System.out.println("User "+user+" logged in.");
                return;
            };
            count++;
        }
        System.out.println("User "+user+" blocked!");
    }
}
