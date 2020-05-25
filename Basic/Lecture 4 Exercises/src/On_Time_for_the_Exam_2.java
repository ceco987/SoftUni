import java.util.Scanner;

public class On_Time_for_the_Exam_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examHour = Integer.parseInt(scanner.nextLine());
        int examMin = Integer.parseInt(scanner.nextLine());
        int arrHour = Integer.parseInt(scanner.nextLine());
        int arrMin = Integer.parseInt(scanner.nextLine());
        int examTotal = (examHour * 60) + examMin;
        int arrTotal = (arrHour * 60) + arrMin;
        String time="";
        if (arrTotal > examTotal) {
            int diff = arrTotal - examTotal;
            time="Late";
            if (diff >= 60) {
                int diffHours = diff / 60;
                int diffMins = diff % 60;
                System.out.printf("%s\n%d:%02d hours after the start", time, diffHours, diffMins);
            } else {
                System.out.printf("%s\n%d minutes after the start",time, diff);
            }
        } else if (arrTotal < examTotal) {
            int diff = examTotal - arrTotal;
            if (diff > 30 && diff < 60) {
                int diffHours = diff / 60;
                int diffMins = diff % 60;
                time="Early";
                System.out.printf("%s\n%02d minutes before the start",time, diffMins);
            } else if (diff > 30 && diff >= 60) {
                int diffHours = diff / 60;
                int diffMins = diff % 60;
                time="Early";
                System.out.printf("%s\n%d:%02d hours before the start",time, diffHours, diffMins);
            } else {
               time="On time";
                System.out.printf("%s\n%d minutes before the start",time, diff);
            }
        } else {
            time="On time";
            System.out.println(time);
        }
    }
}