import java.util.Scanner;

public class New_House {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flowers = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double flowerPrice = 0;
        double ost=0;
        switch(flowers){
            case "Roses":
                if(a>80){
                    flowerPrice=0.9*a*5;
                }
                else{
                    flowerPrice=a*5;
                }
                break;
            case "Dahlias":
                if(a>90){
                    flowerPrice=0.85*a*3.8;
                }
                else {
                    flowerPrice=a*3.8;
                }
                break;
            case "Tulips":
                if(a>80){
                    flowerPrice=0.85*a*2.8;
                }
                else{
                    flowerPrice=a*2.8;
                }
                break;
            case "Narcissus":
                if(a<120) flowerPrice=a*3+(a*3)*0.15;
                else flowerPrice=a*3;
                break;
            case "Gladiolus":
                if(a<80) flowerPrice=a*2.5+(a*2.5)*0.2;
                else flowerPrice=a*2.5;
                break;
        }
        ost=Math.abs(flowerPrice-budget);
        if(flowerPrice<=budget) System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",a,flowers,ost);
        else System.out.printf("Not enough money, you need %.2f leva more.",ost);
    }
}
