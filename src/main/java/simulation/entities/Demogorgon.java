package simulation.entities;

import simulation.Attacking;

public abstract class Demogorgon extends Creature implements Attacking {
    protected final int SPEED_DEMOGORG = 2;
    protected final int HEALTH_DEMOGORG = 100;
    protected final int HUNGER_DEMOGORG = 20;
    protected final int POWER_ATTACK = 20;

    public Demogorgon() {
    }
}
