import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[]a= scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());
        String temp = "";
        for (int i = 0; i < rotations % a.length; i++) {
            temp = a[0];
            for (int j = 0; j < a.length-1; j++) {
                a[j]=a[j+1];
            }
            a[a.length-1]=temp;
        }
        System.out.println(String.join(" ",a));
    }
}
