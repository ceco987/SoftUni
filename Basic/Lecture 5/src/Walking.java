import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int steps=0;
        int rest=0;
        while (true) {
            String a = scanner.nextLine();
            if(a.equalsIgnoreCase("Going home")){
                rest=Integer.parseInt(scanner.nextLine());
                if(rest+steps>=10000) {
                    System.out.println("Goal reached! Good job!");
                    break;
                }
                else{
                    steps=10000-(rest+steps);
                    System.out.printf("%d more steps to reach goal.",steps);
                    break;
                }
            }
            steps+=Integer.parseInt(a);
            if(steps>=10000){
                System.out.println("Goal reached! Good job!");
                break;
            }
        }
    }
}
