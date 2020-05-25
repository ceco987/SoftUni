import java.util.Scanner;

public class Number_in_Range {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        while(a<1||a>100){
            System.out.println("Invalid number");
            System.out.print("Enter a valid number in the range [1...100]: ");
            a = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("The number is: " + a);
    }
}
