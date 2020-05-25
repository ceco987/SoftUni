import java.util.Scanner;

public class Magic_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        for (int first = 1; first <= 9; first++) {
            for (int second = 1; second <= 9; second++) {
                for (int third = 1; third <= 9; third++) {
                    for (int forth = 1; forth <= 9; forth++) {
                        for (int fifth = 1; fifth <= 9; fifth++) {
                            for (int sixth = 1; sixth <= 9; sixth++) {
                                if(first*second*third*forth*fifth*sixth==num) System.out.printf("%d%d%d%d%d%d ",first,second,third,forth,fifth,sixth);
                            }
                        }
                    }
                }
            }
        }
    }
}
