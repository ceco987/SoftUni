import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double resto = Double.parseDouble(scanner.nextLine());
        double moneti = resto * 100;
        int count=0;
        while(moneti>=200){
            moneti-=200;
            count++;
        }
        while(moneti>=100){
            moneti-=100;
            count++;
        }
        while(moneti>=50){
            moneti-=50;
            count++;
        }
        while(moneti>=20){
            moneti-=20;
            count++;
        }
        while(moneti>=10){
            moneti-=10;
            count++;
        }
        while(moneti>=5){
            moneti-=5;
            count++;
        }
        while(moneti>=2){
            moneti-=2;
            count++;
        }
        while(moneti>=1){
            moneti-=1;
            count++;
        }
        System.out.println(count);
    }
}
