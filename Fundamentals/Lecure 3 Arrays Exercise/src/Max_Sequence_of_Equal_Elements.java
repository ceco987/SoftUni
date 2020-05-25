import java.util.Scanner;

public class Max_Sequence_of_Equal_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int maxCount = 0;
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            int currentCount = 0;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i].equals(arr[j])) {
                    currentCount++;
                    if (currentCount > maxCount)
                    {
                        maxCount = currentCount;
                        index=i;
                    }
                }
                else break;
            }
        }
        for (int i = index; i <=index+maxCount ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}