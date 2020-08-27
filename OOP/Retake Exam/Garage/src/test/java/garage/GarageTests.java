package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GarageTests {
    @Before
    public void setUp() {
        Garage garage = new Garage();
        Car car = new Car("domat",5, 5.5);
    }

    @Test
    public void addCar() {
        Garage garage = new Garage();
        Car car = new Car("domat",5, 5.5);
        garage.addCar(car);
        Assert.assertEquals(new Car("domat",5, 5.5).getPrice(),car.getPrice(),0.0);
        Assert.assertEquals(new Car("domat",5, 5.5).getBrand(),car.getBrand());
        Assert.assertEquals(new Car("domat",5, 5.5).getMaxSpeed(),car.getMaxSpeed());
    }
}