import java.util.Scanner;

public class Best_Player {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String best="";
        int a=0;
        int max=0;
        while(a<10){
            name=scanner.nextLine();
            if(name.equals("END")) break;
            a = Integer.parseInt(scanner.nextLine());
            if(max<a){
                max=a;
                best=name;
            }
        }
        System.out.printf("%s is the best player!\n",best);
        if(max>2)
            System.out.printf("He has scored %d goals and made a hat-trick !!!",max);
        else System.out.printf("He has scored %d goals.",max);

    }
}
