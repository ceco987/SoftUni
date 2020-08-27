package easterRaces.entities.cars;

public class SportsCar extends BaseCar{
    public SportsCar(String model, int horsePower, double cubicCentimeters) {
        super(model, horsePower, cubicCentimeters);
        setCubicCentimeters(3000);
    }

    @Override
    public void setCorrectHorsePower(int horsePower, int min, int max) {
        horsePower=getHorsePower();
        min=250;
        max=450;
        super.setCorrectHorsePower(horsePower, min, max);
    }

}
