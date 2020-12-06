import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static setup.Setup.connection;
import static setup.Setup.setConnection;

public class RemoveVillain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter villain ID: ");
        int villainID = Integer.parseInt(scanner.nextLine());

        try {
            setConnection();
            if(checkIfVillainExists(villainID)){
                PreparedStatement ps = connection.prepareStatement("DELETE from minions_villains where villain_id = ?");
                ps.setInt(1,villainID);
                int rescuedMinions = ps.executeUpdate();
                ps = connection.prepareStatement("SELECT name from villains where id = ?");
                ps.setInt(1,villainID);
                ResultSet rs = ps.executeQuery();
                rs.next();
                String villainDeleted = rs.getString(1);
                ps = connection.prepareStatement("DELETE from villains where id = ?");
                ps.setInt(1,villainID);
                ps.execute();
                System.out.println(villainDeleted+" was deleted.");
                System.out.printf("%d minions released.",rescuedMinions);
            }
            else System.out.print("No such villain was found.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static boolean checkIfVillainExists(int villainID) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT minion_id from minions_villains where villain_id = ?");
        ps.setInt(1,villainID);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}
