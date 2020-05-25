import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        double grade =0;
        double sum =0;
        int counter=1;
        while(counter<13){
            grade = Double.parseDouble(scanner.nextLine());
            if(grade>=4)
            {sum+=grade;
            counter++;
            }
        }
        sum/=12;
        System.out.printf("%s graduated. Average grade: %.2f",a,sum);
    }
}
