import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int counter = 1;
        int sumGrade = 0;
        double averageGrade = 0;
        boolean isExcluded = false;
        int timesExcluded = 0;
        while(counter <= 12) {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade >= 4) {
                counter++;
                sumGrade += grade;
            }
            averageGrade = sumGrade / 12.0;
            while (grade< 4) {
                timesExcluded++;
                grade=Double.parseDouble(scanner.nextLine());
                if (timesExcluded == 2) {
                    isExcluded = true;
                    break;
                }
                System.out.printf("%s has been excluded at %d grade",name,counter);
            }
        }
        System.out.printf("%s graduated. Average grade: %.2f",name,averageGrade);
    }
}
