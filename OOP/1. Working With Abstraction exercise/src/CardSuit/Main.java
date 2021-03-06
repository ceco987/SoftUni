package CardSuit;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder("Card Suits: ").append(System.lineSeparator());
        Arrays.stream(Suits.values())
                .forEach(e->{
                    output.append(String.format("Ordinal value: %d; Name value: %s%n",
                            e.ordinal(),e.name()));
                });
        System.out.print(output.toString().trim());
    }
}
