package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;
import static easterRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car{
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        this.horsePower = horsePower;
        setCubicCentimeters(cubicCentimeters);
    }

    public void setCorrectHorsePower(int horsePower, int min, int max) {
        if (horsePower>=min&&horsePower<=max){
            this.horsePower = horsePower;
        }
        else throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
    }

    public void setModel(String model){
        if (model==null|| model.matches("\\s+") || model.length() < 4){
            throw new IllegalArgumentException(String.format(INVALID_MODEL,model,4));
        }
        else {
            this.model = model;
        }
    }

    @Override
    public double calculateRacePoints (int laps){
        return cubicCentimeters/horsePower*laps;
    }

    public void setCubicCentimeters(double cubicCentimeters){
        this.cubicCentimeters=cubicCentimeters;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }
}
