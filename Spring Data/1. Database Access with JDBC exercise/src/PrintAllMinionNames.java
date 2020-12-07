import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import static setup.Setup.connection;
import static setup.Setup.setConnection;

public class PrintAllMinionNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] test = {1,2,3,4,5};

        try {
            setConnection();
            PreparedStatement ps = connection.prepareStatement("select count(*) from minions where id in (?)");
            ps.setString(1, Arrays.toString(test).replaceAll("[\\[\\]]",""));
            ResultSet rs = ps.executeQuery();
            rs.next();

            int minionsCount = rs.getInt(1);
            String[] minionsArray = new String[minionsCount];
            int count = 0;

            ps = connection.prepareStatement("SELECT name from minions");
            rs = ps.executeQuery();
            while(rs.next()){
                minionsArray[count++] = rs.getString(1);
            }

            count=1;
            StringBuilder output = new StringBuilder();
            int q = minionsArray.length%2==0 ? 0 : 1;
            for (int i = 0, j=0; j < minionsArray.length+q;) {
                if (j%2==0) {
                    output.append(String.format("|%d. %-18s|",i+1,minionsArray[i])).append(System.lineSeparator());
                    i++;
                }
                else {
                    output.append(String.format("|%d. %18s|",minionsArray.length-count+1,minionsArray[minionsArray.length-count])).append(System.lineSeparator());
                    count++;
                }
                j++;
            }

            System.out.print(output.toString().trim());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
