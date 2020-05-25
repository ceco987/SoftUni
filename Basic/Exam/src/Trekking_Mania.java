import java.util.Scanner;

public class Trekking_Mania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = Integer.parseInt(scanner.nextLine());
        int musala=0;
        int monblan=0;
        int kili=0;
        int k2=0;
        int everest=0;
        int total=0;
        for (int i = 1; i <=groups ; i++) {
            int people=Integer.parseInt(scanner.nextLine());
            if(people<=5) musala+=people;
            else if(people<=12) monblan+=people;
            else if (people<=25) kili+=people;
            else if(people<=40) k2+=people;
            else everest+=people;
            total+=people;
        }
        System.out.printf("%.2f%%\n",(double)musala/total*100);
        System.out.printf("%.2f%%\n",(double)monblan/total*100);
        System.out.printf("%.2f%%\n",(double)kili/total*100);
        System.out.printf("%.2f%%\n",(double)k2/total*100);
        System.out.printf("%.2f%%\n",(double)everest/total*100);
    }
}
