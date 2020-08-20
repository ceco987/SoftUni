package robotService.models;

import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.INVALID_ENERGY;
import static robotService.common.ExceptionMessages.INVALID_HAPPINESS;

public abstract class BaseRobot implements Robot {
    private String name;
    private int happiness;
    private int energy;
    private int procedureTime;
    private String owner = "Service";
    private boolean isBought;
    private boolean isRepaired;

    protected BaseRobot(String name, int energy, int happiness, int procedureTime) {
        this.name = name;
        setEnergy(energy);
        setHappiness(happiness);
        this.procedureTime = procedureTime;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHappiness() {
        return this.happiness;
    }

    @Override
    public void setHappiness(int happiness) {
        if (happiness < 0 || happiness > 100)
            throw new IllegalArgumentException(INVALID_HAPPINESS);
        this.happiness = happiness;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public void setEnergy(int energy) {
        if (energy < 0 || energy > 100)
            throw new IllegalArgumentException(INVALID_ENERGY);
        this.energy=energy;
    }

    @Override
    public int getProcedureTime() {
        return this.procedureTime;
    }

    @Override
    public void setProcedureTime(int procedureTime) {
        this.procedureTime=procedureTime;
    }

    @Override
    public void setOwner(String owner) {
        this.owner=owner;
    }

    @Override
    public void setBought(boolean bought) {
        this.isBought=bought;
    }

    @Override
    public boolean isRepaired() {
        return this.isRepaired;
    }

    @Override
    public void setRepaired(boolean repaired) {
        this.isRepaired=repaired;
    }

    @Override
    public String toString() {
        return String.format(" %s - %s - Happiness: %d - Energy: %d%n", this.getClass().getSimpleName(),
                this.getName(),
                this.getHappiness(),
                this.getEnergy()
        );
    }
}
