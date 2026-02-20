package simulation.entities;

import simulation.WalkMove;
import simulation.WorldMap;

public final class Soldier extends Survivor {
    private int countShot = 0;
    public Soldier() {
        super(RationBox.class, Demodog.class, new WalkMove());
        speed = SPEED_SURVIVOR;
        health = HEALTH_SURVIVOR;
        hunger = HUNGER_SURVIVOR;
        countShot = COUNT_SHOT_SOLDIER;
        powerAttack = POWER_ATTACK_SOLDIER;
        powerSatiety = POWER_SATIETY_SURVIVOR;
        powerHealing = POWER_HEALING;
    }

    @Override
    protected void attack(WorldMap world, Creature victim) {
        if (countShot > 0) {
            countShot--;
            victim.health = Math.max(0, victim.health - this.powerAttack);
        }
        if (victim.health <= 0) world.removeEntity(victim);
    }
}
