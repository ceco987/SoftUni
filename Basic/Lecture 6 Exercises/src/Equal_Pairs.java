import java.util.Scanner;

public class Equal_Pairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int currentSum=0;
        int previousSum=0;
        int maxDiff=Integer.MIN_VALUE;
        for (int i = 1; i <=n ; i++) {
            int a= Integer.parseInt(scanner.nextLine());
            int b= Integer.parseInt(scanner.nextLine());
            previousSum=currentSum;
            currentSum=a+b;
            if(i==1) continue;
            int diff=Math.abs(currentSum-previousSum);
            if(diff>maxDiff&&previousSum!=currentSum){
                maxDiff=diff;
            }
        }
        if(maxDiff==Integer.MIN_VALUE){
            System.out.printf("Yes, value=%d",currentSum);
        }
        else System.out.printf("No, maxdiff=%d",maxDiff);
    }
}
