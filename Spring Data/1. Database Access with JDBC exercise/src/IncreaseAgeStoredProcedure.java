import java.sql.*;
import java.util.Scanner;

import static setup.Setup.connection;
import static setup.Setup.setConnection;

public class IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minion ID: ");
        int minionID = Integer.parseInt(scanner.nextLine());
        setConnection();
        CallableStatement cs = connection.prepareCall("call usp_get_older(?)");
        cs.setInt(1,minionID);
        cs.execute();
        PreparedStatement ps = connection
                .prepareStatement("SELECT name, age from minions " +
                        "where id = ?");
        ps.setInt(1,minionID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.print(rs.getString(1)+
                    " "+
                    rs.getString(2));
        }
    }
}
