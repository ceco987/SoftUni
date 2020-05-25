import java.util.Scanner;

public class Tayloring_Workshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int masi = Integer.parseInt(scanner.nextLine());
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double ar1=masi*(a+2*0.3)*(b+2*0.3);
        double ar2;
        if(a>b)
            ar2=masi*(a/2)*(a/2);
        else ar2=masi*(b/2)*(b/2);
        double price1=ar1*7+ar2*9;
        double price2=price1*1.85;
        System.out.printf("%.2f USD%n%.2f BGN",price1,price2);
    }
}
