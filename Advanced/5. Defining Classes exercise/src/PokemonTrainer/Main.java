package PokemonTrainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        HashMap<String,Trainer> trainers = new HashMap<>();
        Trainer trainer;
        Pokemon pokemon;

        while (!"Tournament".equals(input=scanner.nextLine())){
            String [] data = input.split("\\s+");
            String trName = data[0];
            String poName = data[1];
            String poElement = data[2];
            int poHealth = Integer.parseInt(data[3]);
            pokemon = new Pokemon(poName,poElement,poHealth);
            trainers.putIfAbsent(trName,new Trainer());
            trainers.get(trName).addPokemon(pokemon);=
        }

        while (!"End".equals(input = scanner.nextLine())){
            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {

            }

            }
        }

    }
}
