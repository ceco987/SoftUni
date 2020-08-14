package PokemonTrainer;

import java.util.ArrayList;

public class Trainer {

    private int badges;
    private String name;
    private ArrayList<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

    public ArrayList<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void increaseBadge() {
        this.badges++;
    }

    public int getBadges(){
        return this.badges;
    }

    public void takeHealth() {
        for (int i = 0; i < this.pokemons.size(); i++) {
         this.pokemons.get(i).decreaseHealth();
         if (this.pokemons.get(i).getHealth()<=0){
             this.pokemons.remove(i);
         }
        }
    }

    @Override
    public String toString(){
        return String.format("%s %d %d%n",this.name,this.badges,this.pokemons.size());
    }

}
