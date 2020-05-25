import java.util.Scanner;

public class Exam_Preparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fail=Integer.parseInt(scanner.nextLine());
        String name="";
        String last="";
        double grade =0;
        int counter=0;
        int problems=0;
        double sum=0;
        while(true){
            name = scanner.nextLine();
            if (name.equals("Enough")) break;
            grade = Double.parseDouble(scanner.nextLine());
            problems++;
            sum+=grade;
            last=name;
            if(grade<=4) counter++;
            if(counter==fail){
                System.out.printf("You need a break, %d poor grades.",counter);
                return;
            }
        }
        System.out.printf("Average score: %.2f\nNumber of problems: %d\nLast problem: %s",sum/problems,problems,last);
    }
}
