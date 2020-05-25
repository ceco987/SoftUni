import java.util.Scanner;

public class Sum_Seconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int sum = a+c+b;
        if (sum<60){
            if (sum<10) System.out.println("0:0"+sum);
            else System.out.println("0:"+sum);
        }
        else{
            int cql=sum/60;
            int ost=sum%60;
            if(ost<10){
                System.out.println(cql+":0"+ost);
            }
            else System.out.println(cql+":"+ost);
        }
    }
}
