package easterRaces.repositories.interfaces;

import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {
    private Collection<Race> models;

    public RaceRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) throws NullPointerException {
        Race ex = null;
        for (Race race : this.models) {
            if (race.getName().equals(name)){
                return race;
            }
        }
        return ex;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Race model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.models.remove(model);
    }
}
