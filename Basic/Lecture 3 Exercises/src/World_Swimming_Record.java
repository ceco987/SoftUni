import java.util.Scanner;
public class World_Swimming_Record {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double distance=Double.parseDouble(scanner.nextLine());
        double time=Double.parseDouble(scanner.nextLine());
        double fin=distance*time;
        double slow1=Math.floor(distance/15);
        double slow=slow1*12.5;
        fin=fin+slow;
        if(fin>=record){
            double result=fin-record;
            System.out.printf("No, he failed! He was %.2f seconds slower.",result);
        }
        else{
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.",fin);
        }
    }
}
