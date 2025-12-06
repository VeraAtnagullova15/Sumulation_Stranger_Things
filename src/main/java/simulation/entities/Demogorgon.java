package simulation.entities;

import simulation.Attacking;

public abstract class Demogorgon extends Creature implements Attacking {
    int powerAttack;
    public Demogorgon(int speed, int health, int hunger) {
        super(speed, health, hunger);
    }
}
