import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class part2 {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/diablo";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Properties props = new Properties();
        props.setProperty("user","root");
        props.setProperty("password","domati");

        try (Connection connection = DriverManager.getConnection(DB_URL,props);
             PreparedStatement stmt = connection.prepareStatement(
                     "SELECT u.first_name, u.last_name, count(ug.id) as count " +
                             "FROM users as u join users_games ug on u.id = ug.user_id " +
                             "WHERE u.user_name = ?"
             );
        ){
            System.out.print("Please enter username: ");
            String user = scanner.nextLine();
            stmt.setString(1,user);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                if (rs.getString("first_name")==null){
                    System.out.print("No such user exists");
                }
                else {
                    String quantifier = rs.getInt("count") == 1 ? "" : "s";
                    System.out.printf("User: %s%n",user);
                    System.out.printf("%s %s has played %d game%s",
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getInt("count"),
                            quantifier);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println("Something went wrong!");
        }
    }
}
