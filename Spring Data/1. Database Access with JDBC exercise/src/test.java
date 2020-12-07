import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import static setup.Setup.connection;
import static setup.Setup.setConnection;

public class test {
    public static void main(String[] args) throws SQLException {
        int[] test = {1,2,3,4};
        setConnection();
        String sql = String.format("SELECT name from minions where id in (%s)",Arrays.toString(test).replaceAll("[\\[\\]]",""));
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        StringBuilder output = new StringBuilder();
        while (rs.next()){
           output.append(rs.getString(1)).append(System.lineSeparator());
        }
        System.out.print(output.toString().trim());
    }
}
