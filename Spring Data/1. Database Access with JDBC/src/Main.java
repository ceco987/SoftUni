import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/soft_uni";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        //Properties and connection
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "domati");
        Connection connection = DriverManager.getConnection(DB_URL, props);

        String statement = "SELECT first_name, last_name FROM employees WHERE salary > ?";
        PreparedStatement stmt = connection.prepareStatement(statement);

        System.out.print("Enter desired salary: ");
        String salary = scanner.nextLine();
        stmt.setDouble(1, Double.parseDouble(salary));
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }

    }
}
