import java.util.ArrayList;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input ="";
        ArrayList<String> data = new ArrayList<>();
        String[]commands = scanner.nextLine().split("[()]");
        int degrees = Integer.parseInt(commands[1])%360;

        int count =0;
        while(!"END".equals(input = scanner.nextLine())){
            data.add(count,input);
            count++;
        }

        int maxLength = Integer.MIN_VALUE;
        for (String el : data) {
            if (el.length() > maxLength) {
                maxLength = el.length();
            }
        }

        switch(degrees){
            case 0:
                for (String el : data) {
                    System.out.println(el);
                }
                break;
            case 90:
                for (int i = 0; i < maxLength; i++) {
                    for (int j = data.size()-1; j>= 0; j--) {
                        String word = data.get(j);
                        if (word.length()<=i){
                            System.out.print(" ");
                            continue;
                        }
                        System.out.print(word.charAt(i));
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int i = data.size()-1; i >= 0; i--) {
                    String word = data.get(i);
                    for (int j = maxLength-1; j >= 0; j--) {
                        if (word.length()<=j){
                            System.out.print(" ");
                            continue;
                        }
                        System.out.print(word.charAt(j));
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int i = maxLength-1; i >= 0; i--) {
                    for (int j = 0; j < data.size(); j++) {
                        String word = data.get(j);
                        if (word.length()<=i){
                            System.out.print(" ");
                            continue;
                        }
                        System.out.print(word.charAt(i));
                    }
                    System.out.println();
                }
                break;
        }
    }
}
