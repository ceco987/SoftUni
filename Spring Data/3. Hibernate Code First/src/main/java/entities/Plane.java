package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "planes")
public class Plane extends Vehicle{
    @Column(name = "passenger_capacity")
    private int passengerCapacity;
    private String airline;

    public Plane(){}

    public Plane(String model, BigDecimal price, String fuelType, int passengerCapacity, String airline) {
        super(model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
        this.airline = airline;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int seats) {
        this.passengerCapacity = seats;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {
        return super.toString()+"plane', " +
                "passengerCapacity='" + passengerCapacity +
                "', airline='" + airline + '\'' +
                "}";
    }
}


