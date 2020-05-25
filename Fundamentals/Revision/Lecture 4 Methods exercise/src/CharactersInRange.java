import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char a = scanner.nextLine().charAt(0);
        char b = scanner.nextLine().charAt(0);
        range(a,b);
    }
    public static void range (char a, char b){
        if((int)a>(int)b)
        {
            char temp =a;
            a=b;
            b=temp;
        }
        for (int i = (int)a+1; i <(int)b ; i++) {
            System.out.print((char)i+" ");
        }
    }
}
