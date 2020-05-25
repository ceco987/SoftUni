import java.util.Scanner;

public class Area_of_Figures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        if(a.equals("square")){
            double b = Double.parseDouble(scanner.nextLine());
            double area=b*b;
            System.out.printf("%.3f",area);
        }
        else if(a.equals("rectangle")){
            double b = Double.parseDouble(scanner.nextLine());
            double c = Double.parseDouble(scanner.nextLine());
            double area = b*c;
            System.out.printf("%.3f",area);
        }
        else if(a.equals("circle")){
            double b = Double.parseDouble(scanner.nextLine());
            double area = Math.PI*b*b;
            System.out.printf("%.3f",area);
        }
        else if(a.equals("triangle")){
            double b = Double.parseDouble(scanner.nextLine());
            double c = Double.parseDouble(scanner.nextLine());
            double area = (b*c)/2;
            System.out.printf("%.3f",area);
        }
    }
}
