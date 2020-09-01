package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.EXISTING_COMPONENT;

public abstract class BaseComputer extends BaseProduct implements Computer {
    //TODO check wtf is happening here
    private List<Component> components;
    private List<Peripheral> peripherals;
    double overallPerformance;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        List<Component> components = new ArrayList<>();
        List<Peripheral> peripherals = new ArrayList<>();
    }

    @Override
    public double getPrice() {
        double sumPeripherals = this.peripherals.stream().mapToDouble(Peripheral::getPrice).sum();
        double sumComponents = this.components.stream().mapToDouble(Component::getPrice).sum();
        return super.getPrice()+sumPeripherals+sumComponents;
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
    public void addComponent(Component component) {
        if (this.components.contains(component.getClass().getSimpleName())){
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    component.getClass().getSimpleName(),
                    this.getModel(),
                    this.getId()));
        }
    }

    @Override
    public Component removeComponent(String componentType) {
        return null;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {

    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        return null;
    }

    @Override
    public double getOverallPerformance() {
        double firstResult = this.overallPerformance;
        if (!components.isEmpty()) {
            return firstResult + this.components.stream().mapToDouble(Component::getOverallPerformance)
                    .average().orElse(0.0);
        }
        return firstResult; //TODO check if this is correct during tests
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        this.components.forEach(e -> output.append("  ").append(e).append(System.lineSeparator()));
        double avgPerformance = this.peripherals.stream().mapToDouble(Product::getOverallPerformance)
                .average().orElse(0.0);
        output.append(String.format(" Peripherals: (%d); Average Overall Performance (%.2f)%n",
                this.peripherals.size(), avgPerformance));
        this.peripherals.forEach(e -> output.append("  ").append(e).append(System.lineSeparator()));
        return super.toString() + System.lineSeparator() +
                String.format(" Components (%d):%n", this.components.size()) +
                output.toString().trim();
    }
}
