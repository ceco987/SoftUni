import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        if(a%10==0) System.out.println("The number is divisible by 10");
        else if(a%7==0) System.out.println("The number is divisible by 7");
        else if(a%6==0) System.out.println("The number is divisible by 6");
        else if(a%3==0) System.out.println("The number is divisible by 3");
        else if(a%2==0) System.out.println("The number is divisible by 2");
        else System.out.println("Not divisible");
    }
}
