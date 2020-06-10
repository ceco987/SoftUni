import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream("resources\\input.txt");
             FileOutputStream fos = new FileOutputStream("resources\\solutions\\outputCopyBytes.txt")
        ) {
            int oneByte = fis.read();
            while (oneByte != -1) {
                String ch = String.valueOf(oneByte);
                if (oneByte!=' ' && oneByte!='\n') {
                    for (int i = 0; i < ch.length(); i++) {
                        fos.write(ch.charAt(i));
                    }
                } else {
                    fos.write((char) oneByte);
                }
                oneByte = fis.read();
            }
        }

    }
}
