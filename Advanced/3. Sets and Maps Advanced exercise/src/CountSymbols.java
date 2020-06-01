import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        Map<Character,Integer> output = new TreeMap<>();
        for (char c : input) {
            if (output.containsKey(c)){
                output.put(c,output.get(c)+1);
            }
            else output.put(c,1);
        }
        for (Map.Entry<Character, Integer> entry : output.entrySet()) {
        printChars(entry);
        }
    }

    private static void printChars(Map.Entry<Character, Integer> entry) {
        System.out.println(entry.getKey()+": "+entry.getValue()+" time/s");
    }
}
