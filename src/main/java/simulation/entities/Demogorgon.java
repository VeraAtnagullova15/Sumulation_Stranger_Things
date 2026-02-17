package simulation.entities;

import simulation.MoveBehavior;
import simulation.WalkMove;

public abstract class Demogorgon extends Creature {
    protected final int SPEED_DEMOGORG = 2;
    protected final int HEALTH_DEMOGORG = 100;
    protected final int HUNGER_DEMOGORG = 30;
    protected final int POWER_ATTACK = 25;


    public Demogorgon(Class<? extends Entity> targetTypeForEat,
                      Class<? extends Creature> targetTypeForAttack, MoveBehavior moveBehavior) {
        super(targetTypeForEat, targetTypeForAttack, new WalkMove());
    }
}
