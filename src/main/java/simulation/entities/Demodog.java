package simulation.entities;

public final class Demodog extends Demogorgon {
    public Demodog() {
        super(Inhabitant.class);
        speed = SPEED_DEMOGORG;
        health = HEALTH_DEMOGORG;
        hunger = HUNGER_DEMOGORG;
        powerAttack = POWER_ATTACK;
    }

    @Override
    public void attack() {
        //TO DO
    }
}
