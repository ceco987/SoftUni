import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Last_Stop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> paintings = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        while(true){
            String[]line=scanner.nextLine().split(" ");
            if(line[0].equals("END")) break;
            switch (line[0]){
                case "Change":
                    if(paintings.contains(Integer.parseInt(line[1]))){
                        paintings.set(paintings.indexOf(Integer.parseInt(line[1])),Integer.parseInt(line[2]));
                    }
                    else continue;
                    break;
                case "Hide":
                    if(paintings.contains(Integer.parseInt(line[1]))){
                       paintings.removeIf(e->e==(Integer.parseInt(line[1])));
                    }
                    else continue;
                    break;
                case "Switch":
                    if(paintings.contains(Integer.parseInt(line[1]))&&paintings.contains(Integer.parseInt(line[2]))){
                        int temp = Integer.parseInt(line[2]);
                        paintings.set(paintings.indexOf(Integer.parseInt(line[2])),Integer.parseInt(line[1]));
                        paintings.set(paintings.indexOf(Integer.parseInt(line[1])),temp);
                    }
                    else continue;
                    break;
                case "Insert":
                    if(paintings.size()>=Integer.parseInt(line[1])){
                        paintings.add((Integer.parseInt(line[1])+1),Integer.parseInt(line[2]));
                    }
                    else continue;
                    break;
                case "Reverse":
                    Collections.reverse(paintings);
                    break;
            }
        }
        System.out.println(paintings.toString().replaceAll("[\\[\\],]",""));
    }
}
