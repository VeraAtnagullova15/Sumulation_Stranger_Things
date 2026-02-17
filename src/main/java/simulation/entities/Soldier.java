package simulation.entities;

import simulation.WalkMove;

public final class Soldier extends Survivor {
    private int countShot;
    public Soldier() {
        super(null, Demodog.class, new WalkMove());
        speed = SPEED_SURVIVOR;
        health = HEALTH_SURVIVOR;
        hunger = HUNGER_SURVIVOR;
        countShot = COUNT_SHOT_SOLDIER;
        powerSatiety = POWER_SATIETY_SURVIVOR;
        powerHealing = POWER_HEALING;
    }

}
