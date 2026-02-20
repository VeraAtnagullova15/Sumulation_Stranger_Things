package simulation.entities;

import simulation.Coordinates;
import simulation.MoveBehavior;
import simulation.WalkMove;
import simulation.WorldMap;

public abstract class Survivor extends Creature {
    protected final int SPEED_SURVIVOR = 1;
    protected final int HEALTH_SURVIVOR = 100;
    protected final int HUNGER_SURVIVOR = 25;
    protected final int COUNT_SHOT_SOLDIER = 8;
    protected final int POWER_SATIETY_SURVIVOR = 15;
    protected final int POWER_HEALING = 5;
    protected final int POWER_ATTACK_SOLDIER = 20;


    public Survivor(Class<? extends Entity> targetTypeForEat,
                    Class<? extends Creature> targetTypeForAttack, MoveBehavior moveBehavior) {
        super(targetTypeForEat, targetTypeForAttack,new WalkMove());
    }

    @Override
    protected void checkCellEffects(WorldMap world, Coordinates nextStep) {
        Entity entityCell = world.getEntity(nextStep);
        if (entityCell instanceof SporePatch) {
            this.health -= 10;
        }
        if (entityCell instanceof Gate) {
            Coordinates randomCell = world.getRandomEmptyPlace();
            world.moveEntity(this, randomCell);
            return;
        }
    }
}


