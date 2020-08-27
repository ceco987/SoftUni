package onlineShop.models.products.components;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;

public abstract class BaseComponent extends BaseProduct implements Component {
    private int generation;

    public BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }

    @Override
    public int getGeneration() {
        return this.generation;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getManufacturer() {
        return super.getManufacturer();
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void setManufacturer(String manufacturer) {
        super.setManufacturer(manufacturer);
    }

    @Override
    public void setModel(String model) {
        super.setModel(model);
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public void setOverallPerformance(double overallPerformance) {
        super.setOverallPerformance(overallPerformance);
    }

    @Override
    public double getOverallPerformance() throws NoSuchFieldException{
        return super.getOverallPerformance();
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(" Generation: %d", this.getGeneration());
    }


}
