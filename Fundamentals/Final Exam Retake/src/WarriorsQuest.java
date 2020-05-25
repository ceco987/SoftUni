import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String skill = scanner.nextLine();
        String input = "";
        while(!"For Azeroth".equals(input=scanner.nextLine())){
            String[]commands = input.split("\\s+");
            String command1 = commands[0];
            String error = "Command doesn't exist!";
            switch(command1){
                case "GladiatorStance":
                    skill=skill.toUpperCase();
                    System.out.println(skill);
                    break;
                case "DefensiveStance":
                    skill=skill.toLowerCase();
                    System.out.println(skill);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(commands[1]);
                    char character = commands[2].charAt(0);
                    if (index<0||index>=skill.length()){
                        System.out.println("Dispel too weak.");
                    }
                    else {
                        StringBuilder sb = new StringBuilder(skill);
                        sb.setCharAt(index,character);
                        skill=sb.toString();
                        System.out.println("Success!");
                    }
                    break;
                case "Target":
                    String subCommand = commands[1];
                    if (subCommand.equals("Change")){
                        String firstSubString= commands[2];
                        String secondSubString = commands[3];
                        skill=skill.replace(firstSubString,secondSubString);
                        System.out.println(skill);
                    }
                    else if (subCommand.equals("Remove")){
                        String forRemoval = commands[2];
                        skill=skill.replace(forRemoval,"");
                        System.out.println(skill);
                    }
                    else System.out.println(error);
                    break;
                default:
                    System.out.println(error);
                    break;
            }
        }
    }
}
