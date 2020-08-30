package easterRaces.entities.cars;

public class SportsCar extends BaseCar{
    public SportsCar(String model, int horsePower, double cubicCentimeters) {
        super(model, horsePower, cubicCentimeters);
        setCorrectHorsePower(horsePower, 250,450);
        setCubicCentimeters(3000);
    }

    @Override
    public void setCorrectHorsePower(int horsePower,int min, int max) {
        super.setCorrectHorsePower(horsePower, min, max);
    }

}
