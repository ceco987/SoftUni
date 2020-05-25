import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque <String> queue = new ArrayDeque<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        int rotations = Integer.parseInt(scanner.nextLine());
        int currentRotation = 0;

        while (queue.size()>1){
            currentRotation++;
            String child = queue.poll();
            if (currentRotation%rotations!=0){
                queue.offer(child);
            }
            else{
                System.out.println("Removed " + child);
            }
        }
        System.out.print("Last is " + queue.poll());
    }

}
