package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    private static Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";

    private static void createConnection (String username, String password, String dbName) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user","root");
        props.setProperty("password","domati");
        connection = DriverManager.getConnection(DB_URL);
    }

    public static Connection getConnection() {
        return connection;
    }
}
