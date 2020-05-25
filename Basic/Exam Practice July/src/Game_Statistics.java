import java.util.Scanner;

public class Game_Statistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.parseInt(scanner.nextLine());
        String name = scanner.nextLine();
        if(min==0) {
            System.out.println("Match has just began!");
            return;
        }
        else if(min<45) System.out.println("First half time.");
        else System.out.println("Second half time.");
        if(min>=1&&min<=10) {
            System.out.printf("%s missed a penalty.%n",name);
            if(min%2==0) System.out.printf("%s was injured after the penalty.",name);
        }
        else if(min>10&&min<=35){
            System.out.printf("%s received yellow card.\n",name);
            if(min%2!=0) System.out.printf("%s got another yellow card.",name);
        }
        else if(min>35&&min<45){
            System.out.printf("%s SCORED A GOAL !!!",name);
        }
        else if(min==45);
        else if(min>45&&min<=55){
            System.out.printf("%s got a freekick.\n",name);
            if(min%2==0) System.out.printf("%s missed the freekick.",name);
        }
        else if(min>55&&min<=80){
            System.out.printf("%s missed a shot from corner.\n",name);
            if(min%2!=0) System.out.printf("%s has been changed with another player.",name);
        }
        else if(min>80&&min<=90) System.out.printf("%s SCORED A GOAL FROM PENALTY !!!",name);
    }
}
