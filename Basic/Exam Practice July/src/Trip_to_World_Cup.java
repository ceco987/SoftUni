import java.util.Scanner;

public class Trip_to_World_Cup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double toTicket = Double.parseDouble(scanner.nextLine());
        double returnTicket = Double.parseDouble(scanner.nextLine());
        double gameTicket = Double.parseDouble(scanner.nextLine());
        int games = Integer.parseInt(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());
        double ticketExpanses=6*(toTicket+returnTicket)*(100-discount)/100;
        double gamesExpanses=6*(games*gameTicket);
        double totalExpanses=ticketExpanses+gamesExpanses;
        System.out.printf("Total sum: %.2f lv.\n",totalExpanses);
        System.out.printf("Each friend has to pay %.2f lv.",totalExpanses/6);
    }
}
