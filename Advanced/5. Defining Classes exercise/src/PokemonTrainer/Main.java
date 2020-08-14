package PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        Pokemon pokemon;

        while (!"Tournament".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");
            String trName = data[0];
            String poName = data[1];
            String poElement = data[2];
            int poHealth = Integer.parseInt(data[3]);
            pokemon = new Pokemon(poName, poElement, poHealth);
            trainers.putIfAbsent(trName, new Trainer(trName));
            trainers.get(trName).addPokemon(pokemon);
        }

        while (!"End".equals(input = scanner.nextLine())) {
            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                boolean isRewarded = false;
                for (Pokemon currentPokemon : entry.getValue().getPokemons()) {
                    if (currentPokemon.getElement().equals(input)) {
                        entry.getValue().increaseBadge();
                        isRewarded = true;
                        break;
                    }
                }
                if (!isRewarded) {
                    entry.getValue().takeHealth();
                }
            }
        }

        trainers.entrySet().stream().sorted((f, s) ->
                Integer.compare(s.getValue().getBadges(), f.getValue().getBadges()))
                .forEach(e -> System.out.print(e.getValue()));

    }
}
