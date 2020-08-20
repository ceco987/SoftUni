package onlineShop.models.products;

import onlineShop.models.products.components.Component;

public abstract class BaseComponent extends BaseProduct implements Component {
    private int generation;

    public BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
        double oldPerformance = this.getOverallPerformance();
        switch (this.getClass().getSimpleName()) {
            case "CentralProcessingUnit", "Motherboard" -> this.setOverallPerformance(oldPerformance * 1.25);
            case "PowerSupply" -> this.setOverallPerformance(oldPerformance * 1.05);
            case "RandomAccessMemory", "SolidStateDrive" -> this.setOverallPerformance(oldPerformance * 1.2);
            case "VideoCard" -> this.setOverallPerformance(oldPerformance * 1.15);
        }

    }

    @Override
    public double getOverallPerformance() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(" Generation: %d", this.getGeneration());
    }


}
