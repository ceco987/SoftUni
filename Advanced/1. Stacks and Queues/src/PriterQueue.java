import java.util.ArrayDeque;
import java.util.Scanner;

public class PriterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque <String> queue = new ArrayDeque<>();
        String input = "";

        while (!"print".equals(input=scanner.nextLine())){
            switch (input){
                case "cancel":
                    if(queue.size()==0){
                        System.out.println("Printer is on standby");
                    }
                    else{
                        System.out.println("Canceled " + queue.poll());
                    }
                    break;
                default:
                    queue.offer(input);
                    break;
            }
        }
        while  (queue.size()>0){
            System.out.println(queue.poll());
        }
    }
}
