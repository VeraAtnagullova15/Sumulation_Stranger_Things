package simulation.entities;

import simulation.Attacking;

public final class Soldier extends Survivor implements Attacking {
    public Soldier(int speed, int health, int hunger) {
        super(speed, health, hunger);
    }

    int countShot;


    @Override
    public void attack() {
        //TO DO
    }
}
