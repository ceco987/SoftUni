import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        String input = "";
        String material = "";
        int quantity = 0;
        Map <String,Integer> output = new LinkedHashMap<>();
        while (!"stop".equals(input=scanner.nextLine())){
            if (count%2!=0){
                material=input;
                count++;
            }
            else {
                quantity = Integer.parseInt(input);
                if (output.containsKey(material)){
                    output.put(material,output.get(material)+quantity);
                }
                else{
                    output.put(material,quantity);
                }
                count++;
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : output.entrySet()) {
            System.out.println(stringIntegerEntry.getKey()+" -> "+stringIntegerEntry.getValue());
        }
    }
}
