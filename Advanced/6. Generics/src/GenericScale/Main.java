package GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(6,7);
        System.out.println(scale.getHeavier());
    }
}
