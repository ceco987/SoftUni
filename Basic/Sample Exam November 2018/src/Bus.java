import java.util.Scanner;

public class Bus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passengers=Integer.parseInt(scanner.nextLine());
        int stops=Integer.parseInt(scanner.nextLine());
        int total=passengers;
        for (int i = 1; i <=stops ; i++) {
            int out = Integer.parseInt(scanner.nextLine());
            int in = Integer.parseInt(scanner.nextLine());
            total=total+in-out;
            if(i%2!=0) total+=2;
            else total-=2;
        }
        System.out.printf("The final number of passengers is : %d",total);
    }
}
