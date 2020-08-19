package vetClinic;

public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic(20);
        clinic.add(new Pet("Ivan", 6, "pencho"));
        clinic.getPet("asd", "asd");
    }
}
