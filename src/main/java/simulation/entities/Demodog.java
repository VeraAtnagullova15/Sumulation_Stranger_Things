package simulation.entities;

import simulation.WalkMove;

public final class Demodog extends Demogorgon {
    public Demodog() {
        super(Inhabitant.class, Soldier.class, new WalkMove());
        speed = SPEED_DEMOGORG;
        health = HEALTH_DEMOGORG;
        hunger = HUNGER_DEMOGORG;
        powerAttack = POWER_ATTACK;
        moveBehavior = new WalkMove();
    }
}
