import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Scanner;

import static setup.Setup.connection;
import static setup.Setup.setConnection;

public class PrintAllMinionNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            setConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT name from minions");
            ResultSet rs = ps.executeQuery();
            ArrayDeque<String> dequeOutput = new ArrayDeque<>();
            int count = 0;
            while (rs.next()) {
                dequeOutput.offer(rs.getString(1));
            }
            while (!dequeOutput.isEmpty()) {
                if(count++%2==0)
                {
                    System.out.println(dequeOutput.pop());
                }
                else System.out.println(dequeOutput.pollLast());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
