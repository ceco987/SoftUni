package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.Comparator;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = new DriverRepository();
        this.carRepository = new CarRepository();
        this.raceRepository = new RaceRepository();
    }

    @Override
    public String createDriver(String driver) {
        Driver result = new DriverImpl(driver);
        if (driverRepository==null||!driverRepository.getAll().contains(result)) {
            driverRepository.add(result);
            return String.format(DRIVER_CREATED,driver);
        }
        throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car result = null;
        if (type.equals("Muscle")) {
            result = new MuscleCar(model, horsePower, 5000);
        } else if (type.equals("Sports")) {
            result = new SportsCar(model, horsePower, 3000);
        }
        if (carRepository.getAll().contains(result)) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        carRepository.add(result);
        return String.format(CAR_CREATED, result.getClass().getSimpleName(),
                model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if (driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        if (carRepository.getByName(carModel) == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }
        Car result = carRepository.getByName(carModel);
        driverRepository.getByName(driverName).addCar(result);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if (raceRepository.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        Driver result = new DriverImpl(driverName);
        raceRepository.getByName(raceName).addDriver(result);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        if (raceRepository.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (raceRepository.getAll().size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }
        Driver[] result;
        result = raceRepository.getByName(raceName).getDrivers().stream()
                .sorted(Comparator.comparing(Driver::getNumberOfWins).reversed())
                .limit(3)
                .toArray(Driver[]::new);
        StringBuilder output = new StringBuilder();
        for (Driver driver : result) {
            output.append(String.format("Driver %s wins %s race.%n", driver.getName(), raceName));

        }
        return output.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        if (!raceRepository.getAll().isEmpty()&&raceRepository.getByName(name).getName().equals(name)) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        Race result = new RaceImpl(name, laps);
        raceRepository.add(result);
        return String.format(RACE_CREATED, name);
    }

    public void End() {
        System.exit(0);
    }

}
