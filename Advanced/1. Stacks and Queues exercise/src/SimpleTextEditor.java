import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> output = new ArrayDeque<>();

        while (n-->0){
        String[] input = scanner.nextLine().split("\\s+");
        int command = Integer.parseInt(input [0]);
        String text = "";
        if (input.length>1) {
            text = input[1];
        }
                switch (command){
                case 1:
                    if (output.isEmpty()||output.peek().length()<1){
                    output.push(text);
                    }
                    else {
                        String a = output.peek() + text;
                        output.push(a);
                    }
                    break;
                case 2:
                    int index = Integer.parseInt(text);
                    String newWord = output.peek().substring(0,output.peek().length()-index);
                    output.push(newWord);
                    break;
                case 3:
                    System.out.println(output.peek().charAt(Integer.parseInt(text)-1));
                    break;
                case 4:
                    output.pop();
                    break;
            }
        }
    }
}
