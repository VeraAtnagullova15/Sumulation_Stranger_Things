package simulation.entities;

public final class Inhabitant extends Survivor {

    public Inhabitant() {
        super(RationBox.class);
        speed = SPEED_SURVIVOR;
        health = HEALTH_SURVIVOR;
        hunger = HUNGER_SURVIVOR;
    }
}
