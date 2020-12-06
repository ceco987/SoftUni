import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import static setup.Setup.connection;
import static setup.Setup.setConnection;

public class ChangeTownNameCasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select country: ");
        String country = scanner.nextLine();

        try {
            setConnection();
            int cityCount;
            String sqlStatement = "UPDATE towns SET name = upper(name) where country = ?";
            PreparedStatement st = connection.prepareStatement(sqlStatement);
            st.setString(1,country);
            cityCount = st.executeUpdate();
            if(cityCount<1) System.out.print("No town names were affected.");
            else {
                String[]output = new String[cityCount];
                sqlStatement = String.format("SELECT name from towns where country = '%s'",country);
                PreparedStatement ps = connection.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                for (int i=0;rs.next();i++){
                    output[i]=rs.getString(1);
                }
                System.out.print(Arrays.toString(output));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
