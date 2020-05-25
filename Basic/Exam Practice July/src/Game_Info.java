import java.util.Scanner;

public class Game_Info {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String team = scanner.nextLine();
        int matches = Integer.parseInt(scanner.nextLine());
        int count=0;
        int duzpiCount=0;
        int produljenieCount=0;
        for (int i = 0; i <matches; i++) {
            int duration = Integer.parseInt(scanner.nextLine());
            count+=duration;
            if(duration>90&&duration<121) produljenieCount++;
            if(duration>120) duzpiCount++;
        }
        System.out.printf("%s has played %d minutes. Average minutes per game: %.2f\n",team,count,(double)count/matches);
        System.out.printf("Games with penalties: %d\n",duzpiCount);
        System.out.printf("Games with additional time: %d",produljenieCount);
    }
}
