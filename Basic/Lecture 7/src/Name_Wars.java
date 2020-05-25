import java.util.Scanner;

public class Name_Wars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name=scanner.nextLine();
        String winner="";
        int max=Integer.MIN_VALUE;
        int sum=0;
        while(!name.equals("STOP")){
            for (int i = 0; i <name.length() ; i++) {
                sum+=name.charAt(i);
            }
            if(max<sum){
                max=sum;
                winner=name;
            }
            name=scanner.nextLine();
            sum=0;
        }
        System.out.printf("Winner is %s - %d!",winner,max);
    }
}
