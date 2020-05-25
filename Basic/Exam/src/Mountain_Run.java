import java.util.Scanner;

public class Mountain_Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double time = Double.parseDouble(scanner.nextLine());

        double total=distance*time;
        double slow=Math.floor((distance/50))*30;
        total+=slow;
        double diff=record-total;
        if(diff>0) System.out.printf("Yes! The new record is %.2f seconds.",total);
        else System.out.printf("No! He was %.2f seconds slower.",Math.abs(diff));
    }
}
