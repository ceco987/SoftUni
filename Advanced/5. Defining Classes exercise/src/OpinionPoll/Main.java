package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        while (n-->0){
        String name = scanner.next();
        int age = scanner.nextInt();
        people.add(new Person(name,age));
        }

        people.stream().filter(a->a.age>30)
                .sorted(Comparator.comparing(p->p.name))
                .forEach(System.out::println);

    }
}
