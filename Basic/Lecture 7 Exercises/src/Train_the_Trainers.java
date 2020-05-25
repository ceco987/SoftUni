import java.util.Scanner;

public class Train_the_Trainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        String name = scanner.nextLine();
        double count=0;
        int grandCount=0;
        double gradeTotal=0;
        while(!name.equals("Finish")){
            for (int i = people; i >=1 ; i--) {
                double grade=Double.parseDouble(scanner.nextLine());
                count+=grade;
            }
            System.out.printf("%s - %.2f.\n",name,count/people);
            gradeTotal+=count/people;
            grandCount++;
            count=0;
            name=scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.",gradeTotal/grandCount);
    }
}
