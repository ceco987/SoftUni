import setup.Setup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionsNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Setup.setConnection();
        String statement = "SELECT m.name, m.age\n" +
                "FROM minions as m\n" +
                "join minions_villains mv on m.id = mv.minion_id\n" +
                "where mv.villain_id = ?";

        PreparedStatement stmt = Setup.connection.prepareStatement(statement);
        System.out.print("Enter villain ID: ");
        int villainID = Integer.parseInt(scanner.nextLine());
        System.out.println();
        String villain = findVillain (villainID);
        if (villain.isBlank()) {
            System.out.printf("No villain with ID %d exists in the database.",villainID);
            return;
        }
        System.out.println("Villain: "+villain);
        stmt.setInt(1,villainID);
        ResultSet rs = stmt.executeQuery();
        int count = 1;
        StringBuilder output = new StringBuilder();
        while(rs.next()){
            output.append(count++)
                    .append(". ")
                    .append(rs.getString("name"))
                    .append(" ")
                    .append(rs.getInt ("age"))
                    .append(System.lineSeparator());
        }
        System.out.print(output.toString().trim());
    }

    private static String findVillain(int villainID) throws SQLException{
        String findVillain = "SELECT name FROM villains WHERE id = ?";
        PreparedStatement stmt = Setup.connection.prepareStatement(findVillain);
        stmt.setInt(1,villainID);
        ResultSet rs = stmt.executeQuery();
        return rs.next() ? rs.getString("name") : "";
    }
}