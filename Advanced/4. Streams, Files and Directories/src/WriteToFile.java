import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        Set<Character> lookUp = Set.of(',', '.', '!', '?');
        try (FileInputStream fis = new FileInputStream("resources\\input.txt");
             FileOutputStream fos = new FileOutputStream("resources\\solutions\\outputWriteToFile.txt")
        ) {
            int oneByte = fis.read();
            while (oneByte!=-1) {
                if (!lookUp.contains((char)oneByte)){
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }
        }
    }
}
