package Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[]strings = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1)
                .toArray(String[]::new);

        ListyIterator test = new ListyIterator(strings);
        String input;
        while (!"END".equals(input=scanner.nextLine())){
            switch (input){
                case"Move":
                    System.out.println(test.move());
                    break;
                case "HasNext":
                    System.out.println(test.hasNext());
                    break;
                case "Print":
                    try {
                        System.out.println(test.print());
                    }
                    catch (UnsupportedOperationException ex){
                        System.out.print(ex.getMessage());
                    }
                    break;
                case "PrintAll":
                try {
                    System.out.println(test.printAll());
                }
                catch (UnsupportedOperationException ex){
                    System.out.println(ex.getMessage());
                }
                    break;
            }
        }

    }
}
