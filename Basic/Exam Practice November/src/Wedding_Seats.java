import java.util.Scanner;

public class Wedding_Seats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lastSector=scanner.nextLine();
        int rows=Integer.parseInt(scanner.nextLine());
        int oddSeats=Integer.parseInt(scanner.nextLine());
        int sectors = lastSector.charAt(0)-'A'+1;
        int seatsCount=0;
        for (int i = 0; i <sectors ; i++) {
            for (int j = 1; j <=rows+i ; j++) {
                if(j%2!=0) {
                    for (int k = 0; k < oddSeats; k++) {
                        System.out.printf("%c%d%c\n",'A'+i,j, 'a' + k);
                        seatsCount++;
                    }
                }
                else for (int k = 0; k <oddSeats+2 ; k++) {
                    System.out.printf("%c%d%c\n",'A'+i,j, 'a' + k);
                    seatsCount++;
                }
            }
        }
        System.out.println(seatsCount);
    }
}