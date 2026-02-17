package simulation.entities;

import simulation.MoveBehavior;
import simulation.WalkMove;

public final class Inhabitant extends Survivor {

    public Inhabitant() {
        super(RationBox.class, null, new WalkMove());
        speed = SPEED_SURVIVOR;
        health = HEALTH_SURVIVOR;
        hunger = HUNGER_SURVIVOR;
        powerSatiety = POWER_SATIETY_SURVIVOR;
        powerHealing = POWER_HEALING;
    }
}
