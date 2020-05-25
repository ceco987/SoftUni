import java.util.Scanner;

public class Water_Dispencer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int ml=0;
        int counter=0;
        while(true) {
            String how = scanner.nextLine();
            if (how.equalsIgnoreCase("Easy")) {
                ml += 50;
            } else if (how.equalsIgnoreCase("Medium")) {
                ml += 100;
            } else if (how.equalsIgnoreCase("Hard")) {
                ml += 200;
            }
            if(ml<a){
                counter++;
            }
            else if(ml==a){
                System.out.printf("The dispenser has been tapped %d times.",++counter);
                break;
            }
            else{
                int diff=ml-a;
                System.out.printf("%dml has been spilled.",diff);
                break;
            }
        }
    }
}
