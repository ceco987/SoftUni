import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class part2 {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/diablo";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Properties props = new Properties();
        String user;
        String pass;

        try {
            System.out.print("Enter username (leave blank for 'root'): ");
            user = scanner.nextLine().trim();
            user = user.equals("") ? "root" : user;
            props.setProperty("user",user);
            System.out.print("Enter password (leave blank for 'domati'): ");
            pass = scanner.nextLine().trim();
            pass = pass.equals("") ? "domati" : pass;
            props.setProperty("password",pass);
            Connection connection = DriverManager.getConnection(DB_URL,props);
        } catch (SQLException throwables) {
            System.err.println("Incorrect credentials!");
        }
    }
}
