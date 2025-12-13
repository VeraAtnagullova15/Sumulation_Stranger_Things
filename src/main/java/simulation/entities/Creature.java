package simulation.entities;

import simulation.Coordinates;
import simulation.WorldMap;

public abstract class Creature extends Entity {
    protected int speed;
    protected int health;
    protected int hunger;
    protected int powerAttack;
    protected Entity target;

    public Creature() {
    }

    protected abstract Coordinates findTarget(WorldMap worldMap, Entity target);

}
