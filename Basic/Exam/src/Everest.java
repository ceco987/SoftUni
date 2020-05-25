import java.util.Scanner;

public class Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total=5364;
        int count=1;
        while(true){
            String sleep = scanner.nextLine();
            if(sleep.equals("END")) break;
            if(sleep.equals("Yes")) count++;
            if(count>5) break;
            if(total>=8848) break;
            int meters=Integer.parseInt(scanner.nextLine());
            total+=meters;

        }
        if(total>=8848) System.out.printf("Goal reached for %d days!",count);
        else System.out.printf("Failed!\n%d",total);
    }
}
