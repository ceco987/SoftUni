import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "resources\\input.txt";
        String output = "resources\\solutions\\outputReadFile.txt";
        try (FileInputStream fis = new FileInputStream(path);
             FileOutputStream fos = new FileOutputStream(output)){
            int oneByte = fis.read();
            while(oneByte!=-1){
                String character = Integer.toBinaryString(oneByte);
                System.out.print(character + " ");
                for (int i = 0; i < character.length(); i++) {
                    fos.write(character.charAt(i));
                }
                fos.write(' ');
                oneByte=fis.read();
            }
        }
    }
}
