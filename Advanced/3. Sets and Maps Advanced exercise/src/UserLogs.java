import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String masterPattern = "IP=(?<ip>(?<ip4>\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})|(?<ip6>[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4}:[\\da-zA-Z]{1,4})) message='(?<message>.*)' user=(?<user>.{3,50})";
        Pattern fullPattern = Pattern.compile(masterPattern);

        while (!"end".equals(input = scanner.nextLine())) {
            Matcher check = fullPattern.matcher(input);
            check.matches();
            String name = check.group("user");
            String ip = check.group("ip");

        }

    }
}
