package simulation.entities;

import simulation.Coordinates;
import simulation.MoveBehavior;
import simulation.WalkMove;
import simulation.WorldMap;

public abstract class Demogorgon extends Creature {
    protected final int SPEED_DEMOGORG = 2;
    protected final int HEALTH_DEMOGORG = 100;
    protected final int HUNGER_DEMOGORG = 40;
    protected final int POWER_ATTACK = 25;


    public Demogorgon(Class<? extends Entity> targetTypeForEat,
                      Class<? extends Creature> targetTypeForAttack, MoveBehavior moveBehavior) {
        super(targetTypeForEat, targetTypeForAttack, new WalkMove());
    }

    @Override
    protected void checkCellEffects(WorldMap world, Coordinates nextStep) {
        Entity entityCell = world.getEntity(nextStep);
        if (entityCell instanceof Gate) {
            Coordinates randomCell = world.getRandomEmptyPlace();
            world.moveEntity(this, randomCell);
            return;
        }
    }
}
