import java.util.Scanner;

public class MuliplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine()).reverse();
        StringBuilder result = new StringBuilder();
        int multiplier = Integer.parseInt(scanner.nextLine());
        int remainder = 0;
        for (int i = 0; i < input.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(input.charAt(i)));
            if (digit * multiplier <= 9) {
                if (digit * multiplier + remainder > 9) {
                    result.append((digit * multiplier + remainder) % 10);
                    remainder = (digit * multiplier + remainder) / 10;
                }
                else {
                    result.append(digit * multiplier + remainder);
                    remainder = 0;
                }
            }
            else {
                result.append((digit * multiplier + remainder) % 10);
                remainder = (digit * multiplier + remainder) / 10;
            }
            if (i == input.length() - 1 && remainder != 0) {
                result.append(remainder);
            }
        }
        System.out.print(result.reverse());
    }
}
