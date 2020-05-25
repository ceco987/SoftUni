import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while(!"END".equals(input= scanner.nextLine())){
            pal(input);
        }
    }
    static void pal (String a){
        String left ="";
        String right ="";
        for (int i = 0; i<a.length()/2; i++) {
            left+=a.charAt(i);
        }
        for (int i = a.length()-1;(a.length()%2!=0 && i> a.length()/2)||
                                  (a.length()%2==0 && i>=a.length()/2) ; i--) {
            right+=a.charAt(i);
        }
        System.out.println(left.equals(right));
    }
}
