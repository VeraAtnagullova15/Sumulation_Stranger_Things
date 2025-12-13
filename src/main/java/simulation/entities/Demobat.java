package simulation.entities;

import simulation.Flying;

public final class Demobat extends Demogorgon implements Flying {
    public Demobat() {
        speed = SPEED_DEMOGORG;
        health = HEALTH_DEMOGORG;
        hunger = HUNGER_DEMOGORG;
        powerAttack = POWER_ATTACK;
    }

    @Override
    public void attack() {
        //TO DO
    }

    @Override
    public void fly() {
        //TO DO
    }
}
