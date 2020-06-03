import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Map<String, Set<String>> playerInfo = new LinkedHashMap<>();
        List<String> lines = new ArrayList<>();
        Map<Character, Integer> cardPower = Map.of(
                'S', 4,
                'H', 3,
                'D', 2,
                'C', 1,
                'J', 11,
                'Q', 12,
                'K', 13,
                'A', 14
        );
        while (!"JOKER".equals(input = scanner.nextLine())) {
            lines.add(input);
        }
        lines.stream()
                .map(e -> {
                    String[] allInfo = e.split(": ");
                    Set<String> cards = Arrays.stream(allInfo[1].split(", "))
                            .collect(Collectors.toSet());
                    return Map.entry(allInfo[0], cards);
                }).forEach(entry -> {
            playerInfo.putIfAbsent(entry.getKey(), new HashSet<>());
            playerInfo.get(entry.getKey()).addAll(entry.getValue());
        });

        playerInfo.entrySet().stream()
                .forEach(e -> {
                    System.out.printf("%s: %d%n", e.getKey(), e.getValue().stream()
                            .mapToInt(card -> {
                                int power = 0;
                                if (Character.isDigit(card.charAt(0))) {
                                    power = card.charAt(0)-'0'; //e.g. 2 has ASCII value of 50 - 48 (ASCII value of 0) = 2 (ASCII value = char value)
                                    power = power == 1 ? 10 : power;
                                } else {
                                    power = cardPower.get(card.charAt(0));
                                }
                                power *= cardPower.get(card.charAt(card.length() - 1));
                                return power;
                            }).sum()
                    );
                });
    }
}
