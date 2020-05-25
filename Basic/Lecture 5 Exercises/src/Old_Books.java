import java.util.Scanner;

public class Old_Books {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String book = scanner.nextLine();
        int capacity = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        String item="";
        boolean found=false;
        while (!found&&counter < capacity) {
            item = scanner.nextLine();
            if (item.equals(book)) {
                found=true;
            }
            else counter++;
        }
        if(found)System.out.printf("You checked %d books and found it.", counter);
        else System.out.printf("The book you search is not here!%nYou checked %d books.", counter);
    }
}
