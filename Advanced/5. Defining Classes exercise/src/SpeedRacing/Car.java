package SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double fuelCost;
    private double distance;

    public Car(String model, double fuel, double fuelCost) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCost = fuelCost;
        this.distance = 0;
    }

    public String getModel() {
        return model;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void travel(double distance) {
        if (distance * this.fuelCost <= this.fuel) {
            this.fuel -= distance * this.fuelCost;
            this.distance += distance;
        } else System.out.println("Insufficient fuel for the drive");
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f%n",this.model,this.fuel,this.distance);
    }
}