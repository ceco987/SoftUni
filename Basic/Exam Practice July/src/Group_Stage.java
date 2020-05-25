import java.util.Scanner;

public class Group_Stage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String team = scanner.nextLine();
        int games = Integer.parseInt(scanner.nextLine());
        int in=0;
        int out=0;
        int points=0;
        int vkarani=0;
        int polucheni=0;
        for (int i = 0; i < games; i++) {
            vkarani = Integer.parseInt(scanner.nextLine());
            polucheni = Integer.parseInt(scanner.nextLine());
            if(vkarani>polucheni) points+=3;
            else if(vkarani==polucheni) points+=1;
            out+=vkarani;
            in+=polucheni;
        }
        if(out>=in) {
            System.out.printf("%s has finished the group phase with %d points.\n",team,points);
            System.out.printf("Goal difference: %d.",out-in);
        }
        else {
            System.out.printf("%s has been eliminated from the group phase.\n",team);
            System.out.printf("Goal difference: %d.",out-in);
        }
    }
}