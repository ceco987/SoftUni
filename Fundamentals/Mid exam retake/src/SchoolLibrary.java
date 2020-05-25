import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> books = Arrays.stream(scanner.nextLine().split("\\&+"))
                                .collect(Collectors.toList());
        String[]input= scanner.nextLine().split("\\|+");
        while(!input[0].equals("Done")){
            String[]command = input[0].split("\\s+");
            String[]book = new String[input.length-1];
            for (int i = 1; i < input.length; i++) {
                input[i]=input[i].trim();
                book[i-1]=input[i];
            }
            switch(command[0]){
                case "Add":
                    if (!books.contains(book[0]))
                        books.add(0,book[0]);
                    break;
                case "Take":
                    if (books.contains(book[0]))
                        books.remove(book[0]);
                    break;
                case "Swap":
                    if (books.contains(book[0])&&books.contains(book[1]))
                        Collections.swap(books,books.indexOf(book[0]),books.indexOf(book[1]));
                    break;
                case "Insert":
                    books.add(book[0]);
                    break;
                case "Check":
                    int index = Integer.parseInt(book[0]);
                    if (index>=0&&index<books.size()){
                        System.out.println(books.get(index));
                    }
                    break;
            }
            input = scanner.nextLine().split("\\|+");
        }
        System.out.println(String.join(", ", books));

    }
}
