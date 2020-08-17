import java.util.Arrays;

public class Tracker {
    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> cl){
        Arrays.stream(cl.getDeclaredMethods())
                .filter(e-> e.getAnnotation(Author.class) != null)
                .forEach(e-> System.out.printf("%s: %s()%n",
                        e.getAnnotation(Author.class).name(),
                        e.getName()));
    }
    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
