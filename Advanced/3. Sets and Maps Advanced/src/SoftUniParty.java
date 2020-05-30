import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set <String> vips = new TreeSet<>();
        Set <String> regulars = new TreeSet<>();
        Set <String> attend = new TreeSet<>();

        String input = "";
        while (!"PARTY".equals(input = scanner.nextLine())){
            if (Character.isDigit(input.charAt(0))){
                vips.add(input);
            }
            else regulars.add(input);
        }

        String coming = "";
        while (!"END".equals(coming = scanner.nextLine())){
            attend.add(coming);
        }
        vips.removeAll(attend);
        regulars.removeAll(attend);

        System.out.println(vips.size()+regulars.size());
        for (String vip : vips) {
            System.out.println(vip);
        }
        for (String member : regulars) {
            System.out.println(member);
        }
    }
}
