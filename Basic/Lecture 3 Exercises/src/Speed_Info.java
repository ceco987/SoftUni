import java.util.Scanner;
public class Speed_Info {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        if(a<=10){
            System.out.println("slow");
        }
        else if(a<=50){
            System.out.println("average");
        }
        else if(a<=150){
            System.out.println("fast");
        }
        else if(a<=1000){
            System.out.println("ultra fast");
        }
        else{
            System.out.println("extremely fast");
        }
    }
}
