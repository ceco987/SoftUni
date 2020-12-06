import setup.Setup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetVillainsNames {
    public static void main(String[] args) throws SQLException {
        Setup.setConnection();
        String statement = "SELECT v.name, count(*) as count\n" +
                "FROM villains as v\n" +
                "join minions_villains mv on v.id = mv.villain_id\n" +
                "group by v.name\n" +
                "having count > 15\n" +
                "order by count desc";
        PreparedStatement stmt = Setup.connection.prepareStatement(statement);
        ResultSet rs = stmt.executeQuery();
        StringBuilder output = new StringBuilder();
        while (rs.next()) {
            output.append(rs.getString(1))
                    .append(" ")
                    .append(rs.getInt(2))
                    .append(System.lineSeparator());
        }
        System.out.print(output.toString().trim());
    }
}
