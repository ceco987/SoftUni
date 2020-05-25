import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        countVowels(input);
    }
    public static void countVowels(String a){
        int count=0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i)=='a'||a.charAt(i)=='u'||a.charAt(i)=='o'||a.charAt(i)=='i'
            ||a.charAt(i)=='e'||
                    a.charAt(i)=='A'||a.charAt(i)=='U'||a.charAt(i)=='O'||a.charAt(i)=='I'
                    ||a.charAt(i)=='E') count++;
        }
        System.out.println(count);
    }
}
