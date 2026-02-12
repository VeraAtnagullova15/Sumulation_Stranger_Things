package simulation.entities;

import simulation.Coordinates;
import simulation.WorldMap;

public abstract class Survivor extends Creature {
    protected final int SPEED_SURVIVOR = 1;
    protected final int HEALTH_SURVIVOR = 100;
    protected final int HUNGER_SURVIVOR = 10;
    protected final int COUNT_SHOT_SOLDIER = 10;


    public Survivor() {
    }

    @Override
    protected void makeMove(WorldMap world) {
        // find target
        // if target = null, do noting
        Coordinates target = findTarget(world, RationBox.class);
        if (target == null) return;
        // choose next step
        Coordinates current = world.getPosition(this);
        Coordinates nextStep = chooseNextStep(current, target, world);
        // moveEntity if square is available
        if (nextStep.equals(current)) return;
        // moveEntity if square is available
        world.moveEntity(this, nextStep);
    }

    void eat() {
        // TO DO
    }
}


