import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Files.write(Path.of("resources\\solutions\\outputSortLines.txt"),Files.lines(Path.of("resources\\input.txt")).sorted().collect(Collectors.toList()));
    }
}
