import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String year=scanner.nextLine();
        int p = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());
        double sof=(48-h)*3.0/4;
        double home=2.0/3*p;
        double total=sof+home+h;
        switch (year){
            case "leap":
                total=total+0.15*total;
                total=Math.floor(total);
                break;
            case "normal":
                total=Math.floor(total);
                break;
        }
        System.out.printf("%.0f",total);
    }
}
