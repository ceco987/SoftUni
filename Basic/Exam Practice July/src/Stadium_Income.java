import java.util.Scanner;

public class Stadium_Income {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sectors = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());
        double ticketPrice=Double.parseDouble(scanner.nextLine());
        double totalIncome=ticketPrice*capacity;
        double sectorIncome=totalIncome/sectors;
        double charity=(totalIncome-0.75*sectorIncome)/8;
        System.out.printf("Total income - %.2f BGN\nMoney for charity - %.2f BGN",totalIncome,charity);
    }
}
