import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String masterPattern = "IP=(?<ip>(?<ip4>\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})|(?<ip6>[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4})) message='(?<message>.*)' user=(?<user>.{3,50})";
        Pattern fullPattern = Pattern.compile(masterPattern);
        Map<String,Map<String,Integer>> output = new TreeMap<>();

        while (!"end".equals(input = scanner.nextLine())) {
            Matcher check = fullPattern.matcher(input);
            if (check.matches()) {
                String name = check.group("user");
                String ip = check.group("ip");
                output.putIfAbsent(name,new LinkedHashMap<>());
                output.get(name).putIfAbsent(ip,0);
                output.get(name).put(ip,output.get(name).get(ip)+1);
            }
        }
       output.entrySet().forEach(entry -> {
           System.out.println(entry.getKey()+":");
           StringBuilder exit = new StringBuilder();
           entry.getValue().entrySet().forEach(e->{
               exit.append(e.getKey()+" => "+e.getValue()+", ");
           });
           exit.deleteCharAt(exit.length()-1);
           exit.setCharAt(exit.length()-1,'.');
           System.out.println(exit);
       });
    }
}
