package robotService;

import robotService.core.interfaces.Engine;
import robotService.core.EngineImpl;
import robotService.models.garages.GarageImpl;
import robotService.models.garages.interfaces.Garage;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();

    }
}
