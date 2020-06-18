import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] args) {
        File file = new File("Files-and-Streams");
        Path output = Paths.get("solutions\\outputListFiles.txt");
        File[] files = file.listFiles();
        for (File f :  files) {
            if (!f.isDirectory()){
                String print = String.format("%s: [%d]%n",f.getName(),f.length());
                System.out.printf(print);
                Files.write(output);
            }
        }
    }
}
