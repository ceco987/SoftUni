import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("File name: "+input.substring(input.lastIndexOf('\\')+1,input.lastIndexOf('.')));
        System.out.print("File extension: "+input.substring(input.lastIndexOf('.')+1));
    }
}
