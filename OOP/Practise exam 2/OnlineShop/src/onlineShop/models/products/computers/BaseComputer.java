package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;
//TODO check wtf is happening here
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
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(onlineShop.models.products.components.Component component) {

    }

    @Override
    public onlineShop.models.products.components.Component removeComponent(String componentType) {
        return null;
    }

    @Override
    public void addPeripheral(onlineShop.models.products.peripherals.Peripheral peripheral) {

    }

    @Override
    public onlineShop.models.products.peripherals.Peripheral removePeripheral(String peripheralType) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        this.components.forEach(e->output.append("  ").append(e).append(System.lineSeparator()));
        double avgPerformance = this.peripherals.stream().mapToDouble(Product::getOverallPerformance)
        .average().orElse(0.0);
        output.append(String.format(" Peripherals: (%d); Average Overall Performance (%.2f)%n",
                this.peripherals.size(),avgPerformance));
        this.peripherals.forEach(e->output.append("  ").append(e).append(System.lineSeparator()));
        return super.toString()+ System.lineSeparator()+
                String.format(" Components (%d):%n",this.components.size())+
                output.toString().trim();
    }

    @Override
    public double getOverallPerformance() {
        double firstResult = this.overallPerformance;
        if (!components.isEmpty()){
            return firstResult+this.components.stream().mapToDouble(Component::getOverallPerformance)
                    .average().orElse(0.0);
        }
        return firstResult+firstResult;
    }
}
