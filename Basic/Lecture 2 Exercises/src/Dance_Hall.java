import java.util.Scanner;

public class Dance_Hall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double L = Double.parseDouble(scanner.nextLine());
        double W = Double.parseDouble(scanner.nextLine());
        double a = Double.parseDouble(scanner.nextLine());
        double ar=L*W*10000;
        double war=a*a*10000;
        double pei=ar/10;
        double fr=ar-pei-war;
        double fin=fr/(7000+40);
        double krai=Math.floor(fin);
        System.out.printf("%.0f",krai);
    }
}
