import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        validate(password);
    }

    public static void validate(String a) {
        boolean check = true;
        if (a.length() < 6 || a.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            check = false;
        }

        for (int i = 0; i < a.length(); i++) {
            if ((a.charAt(i) >= '0' && a.charAt(i) <= '9')
                    ||(a.charAt(i)>='a'&&a.charAt(i)<='z')
                    ||(a.charAt(i)>='A'&&a.charAt(i)<='Z')) continue;

                else{
                System.out.println("Password must consist only of letters and digits");
                check = false;
                break;
            }

        }

        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) >= '0' && a.charAt(i) <= '9') count++;
        }

        if (count < 2) {
            System.out.println("Password must have at least 2 digits");
            check=false;
        }

        if(check) System.out.println("Password is valid");
    }

}
