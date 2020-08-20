package onlineShop.models.products;

import onlineShop.models.products.peripherals.Peripheral;

public abstract class BasePeripheral extends BaseProduct implements Peripheral {
    private String connectionType;

    public BasePeripheral(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType=connectionType;
    }

    @Override
    public String toString() {
        return super.toString()+
                String.format(" Connection Type: %s",
                        this.getConnectionType());
    }
}
