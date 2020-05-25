import java.util.Scanner;

public class Spaceship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double w = Double.parseDouble(scanner.nextLine());
        double l = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double tall = Double.parseDouble(scanner.nextLine());
        double volume = w*l*h;
        double room= 4*(tall+0.4);
        double astronauts=Math.floor(volume/room);
        if(astronauts<3) System.out.println("The spacecraft is too small.");
        else if(astronauts<11) System.out.printf("The spacecraft holds %.0f astronauts.",astronauts);
        else System.out.println("The spacecraft is too big.");
    }
}