package simulation.entities;

import simulation.Attacking;

public final class Soldier extends Survivor implements Attacking {
    private int countShot;
    public Soldier() {
        speed = SPEED_SURVIVOR;
        health = HEALTH_SURVIVOR;
        hunger = HUNGER_SURVIVOR;
        countShot = COUNT_SHOT_SOLDIER;
    }




    @Override
    public void attack() {
        //TO DO
    }
}
