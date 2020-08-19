package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic(20);

        System.out.println(clinic.getStatistics());

    }
}
