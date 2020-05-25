import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robPair = scanner.nextLine().split(";");
        String[] robName = new String[robPair.length];
        int[] robTime = new int[robPair.length];
        int[] robWork = new int[robPair.length];
        for (int i = 0; i < robPair.length; i++) {
            robName[i]=robPair[i].substring(0,robPair[i].indexOf('-'));
            robTime[i]=Integer.parseInt(robPair[i].substring(robPair[i].indexOf('-')+1));
        }

        int[] inputTime = Arrays.stream(scanner.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int hours = inputTime[0];
        int minutes = inputTime[1];
        int seconds = inputTime[2];
        int totalTime = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque <String> assembly = new ArrayDeque<>();
        String input = "";
        while (!"End".equals(input=scanner.nextLine())){
            assembly.offer(input);
        }

        while (!assembly.isEmpty()){
            boolean taken=false;
            totalTime++;
            String currentProduct = assembly.poll();
            runningRobotTime(robWork);
            for (int i = 0; i < robName.length; i++) {
                if (robWork[i]==0){
                    robWork[i]=robTime[i];
                    hours=(totalTime/3600)%24;
                    minutes=(totalTime/60)%60;
                    seconds=totalTime%3600%60;
                    System.out.println(String.format("%s - %s [%02d:%02d:%02d]",robName[i],currentProduct,hours,minutes,seconds));
                    taken=true;
                    break;
                }
            }
            if (!taken){
                assembly.offer(currentProduct);
            }
        }

    }

    private static void runningRobotTime(int[] robWork) {
        for (int i = 0; i < robWork.length; i++) {
            if (robWork[i]>0){
                robWork[i]--;
            }
        }
    }

}