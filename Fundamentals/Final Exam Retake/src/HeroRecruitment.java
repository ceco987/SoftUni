import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input ="";
        Map<String, List<String>> heroList = new TreeMap<>();
        while(!"End".equals(input=scanner.nextLine())){
            String[]commandList = input.split("[\\s+]");
            String command = commandList[0];
            String hero = commandList[1];
            switch(command) {
                case "Enroll":
                    if (!heroList.containsKey(hero)) {
                        heroList.put(hero, new ArrayList<>());
                    } else {
                        System.out.println(hero + " is already enrolled.");
                    }
                    break;
                case "Learn":
                    if (!heroList.containsKey(hero)) {
                        System.out.println(hero + " doesn't exist.");
                    } else if (heroList.get(hero).contains(commandList[2])) {
                        System.out.println(hero + " has already learnt " + commandList[2]+".");
                    } else {
                        heroList.get(hero).add(commandList[2]);
                    }
                    break;
                case "Unlearn":
                    if (!heroList.containsKey(hero)) {
                        System.out.println(hero + " doesn't exist.");
                    } else if (!heroList.get(hero).contains(commandList[2])) {
                        System.out.println(hero + " doesn't know " + commandList[2]+".");
                    } else {
                        heroList.get(hero).remove(commandList[2]);
                    }
                    break;
            }
        }
        System.out.println("Heroes:");
        heroList.entrySet().stream()
                .sorted((a,b)->Integer.compare(b.getValue().size(),a.getValue().size()))
                .forEach(e-> {
                    System.out.print(String.format("== %s: ",e.getKey()));
                    if (!e.getValue().isEmpty()){
                        System.out.println(String.join(", ", e.getValue().toString().replaceAll("[\\[\\]]","")));
                    }
                    else System.out.println();
                });
    }
}
