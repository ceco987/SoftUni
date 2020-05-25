import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String type="";
        String place="";
        double spent=0;
        switch (season){
            case "winter":
                type="Hotel";
                if(budget<=100){
                    place="Bulgaria";
                    spent=budget*0.7;
                    System.out.printf("Somewhere in %s\n");
                }
        }

    }
}
