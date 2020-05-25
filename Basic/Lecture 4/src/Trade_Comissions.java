import java.util.Scanner;

public class Trade_Comissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city=scanner.nextLine();
        double a = Double.parseDouble(scanner.nextLine());
        double com=-1;
        if(city.equalsIgnoreCase("Sofia")){
            if(a>=0&&a<=500) com=a*0.05;
            else if(a>500&&a<=1000) com=a*0.07;
            else if(a>1000&&a<=10000) com=a*0.08;
            else if(a>10000) com=a*0.12;
        }
        else if(city.equalsIgnoreCase("Varna")){
            if(a>=0&&a<=500) com=a*0.045;
            else if(a>500&&a<=1000) com=a*0.075;
            else if(a>1000&&a<=10000) com=a*0.1;
            else if(a>10000) com=a*0.13;
        }
        else if(city.equalsIgnoreCase("Plovdiv")){
            if(a>=0&&a<=500) com=a*0.055;
            else if(a>500&&a<=1000) com=a*0.08;
            else if(a>1000&&a<=10000) com=a*0.12;
            else if(a>10000) com=a*0.145;
        }
        if(com==-1) System.out.println("error");
        else System.out.printf("%.2f",com);
    }
}
