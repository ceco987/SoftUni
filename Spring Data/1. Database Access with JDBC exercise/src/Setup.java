import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Setup {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/minions_db";
    static Connection connection;

    public static void setConnection() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username <Press ENTER for 'root'>:");
        String user = scanner.nextLine().trim();
        user = user.length() > 0 ? user : "root";
        System.out.print("Password <Press ENTER for 'domati'>:");
        String password = scanner.nextLine().trim();
        password = password.length() > 0 ? password : "domati";

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        connection = DriverManager.getConnection(CONNECTION_STRING, props);
    }
}
