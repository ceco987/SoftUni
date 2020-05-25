import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String bestDNA = "";
        int elements = Integer.parseInt(scanner.nextLine());
        int maxCount = 1, line = 0, bestLine=0, bestSum=0, bestIndex=Integer.MAX_VALUE;
        while (!"Clone them!".equals(input = scanner.nextLine())) {
            int[] dna = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt).toArray();
            ++line;
            int currentIndex=0;
            for (int i = 0; i < elements ; i++) {
                int currentCount = 0;
                for (int j = i; j < elements; j++) {
                    if (dna[i] == dna[j] && dna[j] == 1) {
                        currentCount++;
                        if (currentCount > maxCount) {
                            maxCount = currentCount;
                            currentIndex=i;
                        }
                    } else break;
                }
            }
            int sum=0;
            for (int i = 0; i < dna.length; i++) {
                if(dna[i]==1){
                sum+=dna[i];
                }
            }
            if(currentIndex<bestIndex||sum>bestSum){
                bestDNA="";
                bestIndex=currentIndex;
                bestSum=sum;
                bestLine=line;
                for (int i = 0; i < dna.length; i++) {
                    bestDNA+=dna[i]+" ";
                }
            }
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n%s",bestLine,bestSum,bestDNA);
    }
}