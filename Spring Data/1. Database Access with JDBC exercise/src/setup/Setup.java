package setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Setup {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/minions_db";
    public static Connection connection;

    public static void setConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "domati");
        connection = DriverManager.getConnection(CONNECTION_STRING, props);
    }
}
