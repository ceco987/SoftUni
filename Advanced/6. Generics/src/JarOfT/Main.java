package JarOfT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jar<String> jar = new Jar<>();
        jar.add("domati");
        System.out.println(jar.remove());
    }
}
