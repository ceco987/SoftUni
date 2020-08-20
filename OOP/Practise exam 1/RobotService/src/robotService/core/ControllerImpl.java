package robotService.core;

import robotService.core.interfaces.Controller;
import robotService.models.Cleaner;
import robotService.models.Housekeeper;
import robotService.models.garages.GarageImpl;
import robotService.models.garages.interfaces.Garage;
import robotService.models.procedures.Charge;
import robotService.models.procedures.Repair;
import robotService.models.procedures.Work;
import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.*;
import static robotService.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Garage garage;
    private Procedure charge;
    private Procedure repair;
    private Procedure work;

    public ControllerImpl() {
        this.garage = new GarageImpl();
        this.charge = new Charge();
        this.repair = new Repair();
        this.work = new Work();
    }

    @Override
    public String manufacture(String robotType, String name, int energy, int happiness, int procedureTime) {
        Robot robot;
        if (robotType.equals("Cleaner")) {
            robot = new Cleaner(name, energy, happiness, procedureTime);
        } else if (robotType.equals("Housekeeper")) {
            robot = new Housekeeper(name, energy, happiness, procedureTime);
        } else throw new IllegalArgumentException(String.format(INVALID_ROBOT_TYPE, robotType));
        this.garage.manufacture(robot);
        return String.format(ROBOT_MANUFACTURED, robot.getName());
    }

    @Override
    public String repair(String robotName, int procedureTime) {
        this.repair.doService(getValidRobot(robotName), procedureTime);
        return String.format(REPAIR_PROCEDURE, robotName);
    }

    @Override
    public String work(String robotName, int procedureTime) {
        this.work.doService(getValidRobot(robotName), procedureTime);
        return String.format(WORK_PROCEDURE, robotName, procedureTime);
    }

    @Override
    public String charge(String robotName, int procedureTime) {
        this.charge.doService(getValidRobot(robotName), procedureTime);
        return String.format(CHARGE_PROCEDURE, robotName);
    }

    @Override
    public String sell(String robotName, String ownerName) {
        getValidRobot(robotName);
        this.garage.sell(robotName, ownerName);
        return String.format(SELL_ROBOT, ownerName, robotName);
    }

    @Override
    public String history(String procedureType) {
        switch (procedureType) {
            case "Repair":
                return this.repair.history();
            case "Charge":
                return this.charge.history();
            default:
                return this.work.history();
        }
    }

    private Robot getValidRobot(String name) {
        Robot robot = this.garage.getRobots().get(name);
        if (robot == null)
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, name));
        return robot;
    }

}
