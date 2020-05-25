import java.util.Scanner;

public class Even_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        while(a%2!=0){
            System.out.println("Please write an even number.");
            a=Integer.parseInt(scanner.nextLine());
        }
        System.out.println("The number is: " + Math.abs(a));
    }
}
