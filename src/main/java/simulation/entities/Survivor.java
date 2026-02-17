package simulation.entities;

import simulation.MoveBehavior;
import simulation.WalkMove;

public abstract class Survivor extends Creature {
    protected final int SPEED_SURVIVOR = 1;
    protected final int HEALTH_SURVIVOR = 100;
    protected final int HUNGER_SURVIVOR = 10;
    protected final int COUNT_SHOT_SOLDIER = 10;
    protected final int POWER_SATIETY_SURVIVOR = 40;
    protected final int POWER_HEALING = 10;


    public Survivor(Class<? extends Entity> targetTypeForEat,
                    Class<? extends Creature> targetTypeForAttack, MoveBehavior moveBehavior) {
        super(targetTypeForEat, targetTypeForAttack,new WalkMove());
    }
}


