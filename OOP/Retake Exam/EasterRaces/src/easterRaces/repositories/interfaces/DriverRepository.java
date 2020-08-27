package easterRaces.repositories.interfaces;


import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver> {
    private static Collection<Driver> models;

    public DriverRepository() {
        models = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        for (Driver driver : models) {
            if (driver.getName().equals(name)){
                return driver;
            }
        }
        return null;
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Driver model) {
        models.add(model);
    }

    @Override
    public boolean remove(Driver model) {
        return models.remove(model);
    }
}


