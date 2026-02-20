package simulation.entities;

import simulation.FlyMove;

public final class Demobat extends Demogorgon{
    public Demobat() {
        super(Soldier.class, Inhabitant.class, new FlyMove());
        speed = SPEED_DEMOGORG;
        health = HEALTH_DEMOGORG;
        hunger = HUNGER_DEMOGORG;
        powerAttack = POWER_ATTACK;
    }

}
