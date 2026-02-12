package simulation.entities;

import simulation.Coordinates;
import simulation.WorldMap;

public abstract class Survivor extends Creature {
    protected final int SPEED_SURVIVOR = 1;
    protected final int HEALTH_SURVIVOR = 100;
    protected final int HUNGER_SURVIVOR = 10;
    protected final int COUNT_SHOT_SOLDIER = 10;
    protected Class<? extends Entity> targetType;


    public Survivor(Class<? extends Entity> targetType) {
        super(targetType);

    }

    void eat() {
        // TO DO
    }
}


