package robotService.models.procedures;

import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.interfaces.Robot;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseProcedure implements Procedure {
    protected Collection<Robot> robots;

    protected BaseProcedure() {
        this.robots = new ArrayList<>();
    }

    @Override
    public String history() {
        return null;
    }

    @Override
    public abstract void doService(Robot robot, int procedureTime);
}
