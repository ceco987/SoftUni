import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=input ; i++) {
            if(sum(i)%8==0&&odd(i)){
                System.out.println(i);
            }
        }
    }
    static int sum (int i){
        int sum =0;
        for (int j = 0; j < String.valueOf(i).length(); j++) {
                sum+=Character.getNumericValue(String.valueOf(i).charAt(j));
            }

        return sum;
        }

        static boolean odd (int i){
        boolean flag =false;
        for (int j = 0; j < String.valueOf(i).length(); j++) {
                if(Character.getNumericValue(String.valueOf(i).charAt(j))%2!=0) {
                    flag=true;
                    break;
                }

            }

        return flag;
    }
}
