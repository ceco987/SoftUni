package onlineShop.models.products;

import onlineShop.models.products.computers.Computer;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;
    double overallPerformance;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        List<Component> components = new ArrayList<>();
        List<Peripheral> peripherals = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        this.components.forEach(e->output.append("  ").append(e).append(System.lineSeparator()));
        double avgPerformance = this.peripherals.stream().mapToDouble(Peripheral::getOverallPerformance)
        .average().orElse(0.0);
        output.append(String.format(" Peripherals: (%d); Average Overall Performance (%.2f)%n",
                this.peripherals.size(),avgPerformance));
        this.peripherals.forEach(e->output.append("  ").append(e).append(System.lineSeparator()));
        return super.toString()+ System.lineSeparator()+
                String.format(" Components (%d):%n",this.components.size())+
                output.toString().trim();
    }

    @Override
    public double getOverallPerformance() throws NoSuchFieldException {
        double firstResult = this.overallPerformance;
        if (!components.isEmpty()){
            return firstResult+this.components.stream().mapToDouble(Component::getOverallPerformance)
                    .average().orElse(0.0);
        }
        return firstResult+firstResult;

    }
}
