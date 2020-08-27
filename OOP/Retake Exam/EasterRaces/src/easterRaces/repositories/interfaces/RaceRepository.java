package easterRaces.repositories.interfaces;

import easterRaces.entities.racers.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {
    private static Collection<Race> models;

    public RaceRepository() {
        models = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        for (Race race : models) {
            if (race.getName().equals(name)){
                return race;
            }
        }
        return null;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Race model) {
        models.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return models.remove(model);
    }
}
