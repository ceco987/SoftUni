package PokemonTrainer;

import java.util.HashSet;

public class Trainer {

    private int badges = 0;
    private HashSet<Pokemon> pokemons;

    public Trainer() {
        this.pokemons = new HashSet<>();
    }

    public HashSet<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public void increaseBadge() {
        this.badges++;
    }




}
