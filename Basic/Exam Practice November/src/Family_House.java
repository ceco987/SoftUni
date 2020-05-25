import java.util.Scanner;

public class Family_House {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int months = Integer.parseInt(scanner.nextLine());
        int voda = 20;
        int internet = 15;
        double tokSum=0;
        double others=0;
        for (int i = 0; i <months ; i++) {
            double tokPrice = Double.parseDouble(scanner.nextLine());
            others=others+(tokPrice+voda+internet)*1.2;
            tokSum+=tokPrice;
        }
        System.out.printf("Electricity: %.2f lv%n",tokSum);
        System.out.printf("Water: %.2f lv\n",(double)voda*months);
        System.out.printf("Internet: %.2f lv\n",(double)internet*months);
        System.out.printf("Other: %.2f lv\n",others);
        System.out.printf("Average: %.2f lv\n",(tokSum+voda*months+internet*months+others)/months);
    }
}
