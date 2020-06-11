import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        int count = 1;
        try (FileInputStream fis = new FileInputStream("resources\\input.txt");
             FileOutputStream fos = new FileOutputStream("resources\\solutions\\outputWriteEveryThirdLine.txt");
             Scanner scanner = new Scanner(fis);
             PrintWriter end = new PrintWriter(fos)) {
            while (scanner.hasNextLine()) {
                if (count % 3 == 0) {
                    end.println(scanner.nextLine());
                } else scanner.nextLine();
                count++;
            }
        }

    }
}
