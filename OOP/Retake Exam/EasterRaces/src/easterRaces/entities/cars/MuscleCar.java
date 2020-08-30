package easterRaces.entities.cars;

public class MuscleCar extends BaseCar{
    public MuscleCar(String model, int horsePower, double cubicCentimeters) {
        super(model, horsePower,cubicCentimeters);
        setCorrectHorsePower(horsePower,400,600);
        setCubicCentimeters(5000);
    }

    @Override
    public void setCorrectHorsePower(int horsePower, int min, int max) {
        super.setCorrectHorsePower(horsePower, min, max);
    }
}
