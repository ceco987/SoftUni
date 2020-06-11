import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream("resources\\input.txt");
             FileOutputStream fos = new FileOutputStream("resources\\solutions\\outputExtractIntegers.txt");
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    String oneByte = String.valueOf(scanner.nextInt());
                    for (int i = 0; i < oneByte.length(); i++) {
                        fos.write(oneByte.charAt(i));
                    }
                    fos.write('\n');
                }
                else scanner.next();
            }
        }

    }
}
