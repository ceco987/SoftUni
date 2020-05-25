import java.util.Scanner;

public class Array_Rotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        String temp = "";
        for (int i = 0; i < n%arr.length; i++) {
         temp=arr[0];
            for (int j = 0; j <arr.length-1 ; j++) {
                arr[j]=arr[j+1];
            }
            arr[arr.length-1]=temp;
        }
        System.out.println(String.join(" ", arr));
    }
}
