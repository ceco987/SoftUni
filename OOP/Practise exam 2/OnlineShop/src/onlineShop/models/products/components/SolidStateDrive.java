package onlineShop.models.products.components;

import onlineShop.models.products.peripherals.BasePeripheral;

public class SolidStateDrive extends BaseComponent {
    public SolidStateDrive(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance, generation);
        super.setOverallPerformance(super.getOverallPerformance()*1.20);
    }
}
