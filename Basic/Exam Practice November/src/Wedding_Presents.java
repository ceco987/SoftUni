import java.util.Scanner;

public class Wedding_Presents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guests = Integer.parseInt(scanner.nextLine());
        int presents = Integer.parseInt(scanner.nextLine());
        String type="";
        int countA = 0;
        int countB = 0;
        int countV = 0;
        int countG = 0;
        for (int i = 0; i <presents ; i++) {
            type = scanner.nextLine();
            switch (type){
                case "A":
                    countA++;
                    break;
                case "B":
                    countB++;
                    break;
                case "V":
                    countV++;
                    break;
                case "G":
                    countG++;
                    break;
            }
        }
        System.out.printf("%.2f%%\n",(double)countA/presents*100);
        System.out.printf("%.2f%%\n",(double)countB/presents*100);
        System.out.printf("%.2f%%\n",(double)countV/presents*100);
        System.out.printf("%.2f%%\n",(double)countG/presents*100);
        System.out.printf("%.2f%%\n",(double)presents/guests*100);
    }
}
