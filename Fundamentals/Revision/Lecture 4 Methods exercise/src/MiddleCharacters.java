import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        middle(input);

    }
    public static void middle (String a){
        if(a.length()%2==0){
            System.out.println(a.charAt((a.length())/2-1) +""+ a.charAt((a.length())/2));
        }
        else System.out.println(a.charAt(a.length()/2));

    }
}
