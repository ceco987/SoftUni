import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tabs=Integer.parseInt(scanner.nextLine());
        int salary=Integer.parseInt(scanner.nextLine());
        int fine=0;
        for (int i = 0; i <tabs ; i++) {
            String site=scanner.nextLine();
            switch(site){
                case "Facebook":
                    fine+=150;
                    break;
                case "Instagram":
                    fine+=100;
                    break;
                case"Reddit":
                    fine+=50;
                    break;
            }
            if(fine>=salary){
                System.out.println("You have lost your salary.");
                return;
            }
        }
        System.out.println(salary-fine);
    }
}
