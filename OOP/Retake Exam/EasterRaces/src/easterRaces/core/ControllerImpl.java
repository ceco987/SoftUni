package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.BaseCar;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.Repository;

import java.util.Comparator;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver result = new DriverImpl(driver);
        if (driverRepository.getByName(driver)==null) {
            driverRepository.add(result);
            return String.format(DRIVER_CREATED, driver);
        }
        throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
    }
    @Override
    public String createCar(String type, String model, int horsePower) {
        BaseCar result;
        if (type.equals("Muscle")) {
            result = new MuscleCar(model, horsePower, 5000);
        } else if (type.equals("Sports")) {
            result = new SportsCar(model, horsePower, 3000);
        }
        else result = null;
        if (carRepository.getByName(model)!=null&&result.getClass().getSimpleName().equals(type+"Car")) {
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
        Driver result = driverRepository.getByName(driverName);
        raceRepository.getByName(raceName).addDriver(result);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        if (raceRepository.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (raceRepository.getByName(raceName).getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }
        Driver[] result;
        int numOfLaps = raceRepository.getByName(raceName).getLaps();

        //the method in the block should work as the other, however it's still not tested.
        /*result = raceRepository.getByName(raceName).getDrivers().stream()
                .sorted((f,s)-> (int) (s.getCar().calculateRacePoints(numOfLaps)-f.getCar().calculateRacePoints(numOfLaps)))
                .limit(3)
                .toArray(Driver[]::new);
                */

        result = raceRepository.getByName(raceName).getDrivers().stream()
                .sorted(Comparator.comparing(e->e.getCar().calculateRacePoints(numOfLaps)))
                .limit(3)
                .toArray(Driver[]::new);
        raceRepository.remove(raceRepository.getByName(raceName));
        StringBuilder output = new StringBuilder();
        output.append(String.format(DRIVER_FIRST_POSITION + "%n", result[2].getName(), raceName));
        output.append(String.format(DRIVER_SECOND_POSITION + "%n", result[1].getName(), raceName));
        output.append(String.format(DRIVER_THIRD_POSITION + "%n", result[0].getName(), raceName));
        return output.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
            if (raceRepository.getByName(name)!=null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        Race result = new RaceImpl(name, laps);
        raceRepository.add(result);
        return String.format(RACE_CREATED, name);
    }
}
