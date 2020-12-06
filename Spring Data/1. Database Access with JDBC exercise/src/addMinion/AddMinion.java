package addMinion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static setup.Setup.connection;
import static setup.Setup.setConnection;

public class AddMinion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Minion info [name] [age] [town]: ");
        String[] input = scanner.nextLine().split("\\s+");
        System.out.print("Villain name: ");
        String villainName = scanner.nextLine();

        try {
            setConnection();
            String minionName = input[0];
            int minionAge = Integer.parseInt(input[1]);
            String minionTown = input[2];
            int minionTownID = findTownID(minionTown);
            if (minionTownID == -1) {
                minionTownID = insertTown(minionTown);
                System.out.printf("Town %s successfully added to database.%n", minionTown);
            }
            int villainID = checkVillain(villainName);
            checkIfMinionIsAssigned(minionName, minionAge, minionTownID, villainID, villainName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void checkIfMinionIsAssigned(String minionName, int minionAge, int minionTownID, int villainID, String villainName) throws SQLException {
        String checkIfInMinions = String.format("SELECT id from minions where name = '%s'", minionName);
        PreparedStatement st = connection.prepareStatement(checkIfInMinions);
        ResultSet rs = st.executeQuery();
        if (!rs.next()) {
            PreparedStatement minionInsert = connection
                    .prepareStatement("INSERT INTO minions (`name`,`age`,`town_id`)VALUES " +
                            "(?,?,?)");
            minionInsert.setString(1, minionName);
            minionInsert.setInt(2, minionAge);
            minionInsert.setInt(3, minionTownID);
            minionInsert.execute();
        }
        rs = st.executeQuery();
        rs.next();
        String checkIfAssigned = String.format("SELECT villain_id from minions_villains where minion_id = %d", rs.getInt(1));
        PreparedStatement st2 = connection.prepareStatement(checkIfAssigned);
        ResultSet mvTableCheck = st2.executeQuery();
        if (!mvTableCheck.next()) {
            addInMappingTable(villainID, minionName);
            System.out.printf("Successfully added %s to be minion of %s.", minionName, villainName);
        }
    }

    private static void addInMappingTable(int villainID, String minionName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT `ID` FROM `minions` WHERE `name` = ?");
        ps.setString(1, minionName);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int minionID = rs.getInt("ID");
        PreparedStatement ps2 = connection.prepareStatement("INSERT INTO `minions_villains` values (?,?)");
        ps2.setInt(1, minionID);
        ps2.setInt(2, villainID);
        ps2.execute();
    }

    private static int checkVillain(String villainName) throws SQLException {
        String sqlString = String.format("SELECT `id` from `villains` WHERE `name` = '%s'", villainName);
        PreparedStatement check = connection.prepareStatement(sqlString);
        ResultSet checkRS = check.executeQuery();
        if (!checkRS.next()) {
            PreparedStatement villainInsert = connection
                    .prepareStatement("INSERT INTO villains (`name`,`evilness_factor`) values (?,?)");
            villainInsert.setString(1, villainName);
            villainInsert.setString(2, evilness.EVIL.evilFactor());
            villainInsert.execute();
            System.out.printf("Villain %s was added to the database.%n", villainName);
            PreparedStatement vilID = connection.prepareStatement(sqlString);
            ResultSet rs = vilID.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        return checkRS.getInt(1);
    }

    private static int insertTown(String town) throws SQLException {
        String sqlQuery = String.format("INSERT INTO `towns` (`name`, `country`) VALUES ('%s', 'Misc')", town);
        String resultQuery = "SELECT `id` FROM towns WHERE `name` = ?";
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.execute();
        PreparedStatement rsst = connection.prepareStatement(resultQuery);
        rsst.setString(1, town);
        ResultSet rs = rsst.executeQuery();
        return rs.next() ? rs.getInt(1) : -1;
    }

    private static int findTownID(String town) throws SQLException {
        String sqlStatement = String.format("SELECT `id` FROM `towns` WHERE `name` = '%s'", town);
        PreparedStatement findTown = connection.prepareStatement(sqlStatement);
        ResultSet rs = findTown.executeQuery();
        return rs.next() ? rs.getInt(1) : -1;
    }
}
