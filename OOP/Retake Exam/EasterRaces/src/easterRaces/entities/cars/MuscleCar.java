package easterRaces.entities.cars;

public class MuscleCar extends BaseCar{
    public MuscleCar(String model, int horsePower, double cubicCentimeters) {
        super(model, horsePower,cubicCentimeters);
        setCubicCentimeters(5000);

    }

    @Override
    public void setCorrectHorsePower(int horsePower, int min, int max) {
        horsePower=getHorsePower();
        min=400;
        max=600;
        super.setCorrectHorsePower(horsePower, min, max);
    }
}
