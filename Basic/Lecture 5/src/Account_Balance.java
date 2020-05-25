import java.util.Scanner;

public class Account_Balance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number=Integer.parseInt(scanner.nextLine());
        int counter=0;
        double sum=0;
        while (counter<number) {
            double a = Double.parseDouble(scanner.nextLine());
            if(a<0){
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n",a);
            sum+=a;
            counter++;
        }
        System.out.printf("Total: %.2f",sum);
    }
}
