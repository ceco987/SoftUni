import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import static setup.Setup.connection;
import static setup.Setup.setConnection;

public class IncreaseMinionsName {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        setConnection();
        String sql = String.format("UPDATE minions SET age = age + 1, name = lower(name) WHERE ID IN (%s)",
                Arrays.toString(input).replaceAll("[\\[\\]]", ""));
        PreparedStatement ps = connection
                .prepareStatement(sql);
        ps.execute();
        ps = connection.prepareStatement("SELECT name, age from minions");
        ResultSet rs = ps.executeQuery();
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
