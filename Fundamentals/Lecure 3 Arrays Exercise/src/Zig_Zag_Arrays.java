import java.util.Scanner;

public class Zig_Zag_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] num = new String[n * 2];
        int index = 0;
        int count=0;
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                if (count % 2 == 0) {
                    for (int k = 0; k < input.length; k++) {
                        num[index] = input[k];
                        index++;
                    }
                } else {
                    for (int k = input.length-1; k >= 0; k--) {
                        num[index] = input[k];
                        index++;
                    }
                }
                count++;
                break;
            }
        }
        for (int i = 0; i <num.length ; i++) {
            if(i%2==0){
                System.out.print(num[i]+" ");
            }
        }
        System.out.println();
        for (int i = 0; i < num.length; i++) {
            if(i%2!=0) System.out.print(num[i]+" ");
        }
    }
}