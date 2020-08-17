import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;
        Arrays.stream(clazz.getDeclaredFields())
                .filter(a -> !Modifier.isPrivate(a.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(a -> System.out.printf("%s must be private!%n",
                        a.getName()));
        Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get"))
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s have to be public!%n", m.getName()));

        Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("set") && !Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s have to be private!%n", m.getName()));

    }
}
