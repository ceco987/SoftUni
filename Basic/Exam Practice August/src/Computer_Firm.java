import java.util.Scanner;

public class Computer_Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double salesPerc=0;
        int count = 0;
        double sales=0;
        for (int i = 0; i < n ; i++) {
            int salesRating = Integer.parseInt(scanner.nextLine());
            int rating=salesRating%10;
            switch(rating){
                case 2: salesPerc=0; count+=2; break;
                case 3: salesPerc=0.5; count+=3; break;
                case 4: salesPerc=0.7; count+=4; break;
                case 5: salesPerc=0.85; count+=5; break;
                case 6: salesPerc=1; count+=6; break;
            }
            int possibleSales=salesRating/10;
            sales=sales+salesPerc*possibleSales;
        }
        System.out.printf("%.2f\n%.2f",sales,(double)count/n);
    }
}
