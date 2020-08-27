package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class CarRepository implements Repository<Car> {
    private static Collection<Car> models;

    public CarRepository() {
        models = new ArrayList<Car>();
    }

    @Override
    public Car getByName(String name) {
        for (Car car : models) {
            if (car.getModel().equals(name)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Car model) {
        models.add(model);
    }

    @Override
    public boolean remove(Car model) {
        return models.remove(model);
    }
}
