package simulation.entities;

import simulation.*;

import java.util.ArrayList;

public abstract class Creature extends Entity {
    protected int speed;
    protected int hunger;
    protected int health;
    protected int powerAttack;
    protected Class<? extends Entity> targetTypeForEat;
    protected Class<? extends Creature> targetTypeForAttack;
    protected MoveBehavior moveBehavior;

    public Creature(Class<? extends Entity> targetTypeForEat,
                    Class<? extends Creature> targetTypeForAttack,MoveBehavior moveBehavior) {
        this.targetTypeForEat = targetTypeForEat;
        this.targetTypeForAttack = targetTypeForAttack;
        this.moveBehavior = moveBehavior;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHealth() {
        return health;
    }

    protected Coordinates findTarget(WorldMap world, Class<? extends Entity> targetType) {
        Coordinates myCoordinates = world.getPosition(this);
        int minimalDistance = Integer.MAX_VALUE;
        Coordinates targetCoordinates = null;
        for (Entity entity : world.getEntitiesToCoordinates().keySet()) {
            if (targetType.isInstance(entity)) {
                Coordinates coordinates = world.getPosition(entity);
                int distance = Math.abs(coordinates.row() - myCoordinates.row()) +
                        Math.abs(coordinates.column() - myCoordinates.column());
                if (distance < minimalDistance) {
                    minimalDistance = distance;
                    targetCoordinates = coordinates;
                }
            }
        }
        return targetCoordinates;
    }

    public void makeMove(WorldMap world, BFS bfs) {
        this.hunger += 5;
        if (this.hunger >= 100) {
            this.health -= 5;
            if (this.health <= 0) {
                world.removeEntity(this);
                return;
            }
        }
        if (this.health > 100) this.health = 100;
        System.out.println(this);
        System.out.println("Hunger = " + this.hunger + "; health = " + this.health);

        Coordinates current = world.getPosition(this);
        if (current == null) return;
        Coordinates targetEat = null;
        Coordinates targetAttack = null;
        if (targetTypeForEat != null) {
            targetEat = findTarget(world, targetTypeForEat);
        }
        if (targetTypeForAttack != null) {
            targetAttack = findTarget(world, targetTypeForAttack);
        }

        Coordinates mainTarget = chooseTarget(current, targetEat, targetAttack);
        if (mainTarget == null) return;

        for (int i = 0; i < speed; i++) {
            current = world.getPosition(this);
            if (current == null) return;

            Coordinates nextStep = bfs.findPath(world, this.moveBehavior, current, mainTarget);
            if (nextStep == null) return;

            if (nextStep.equals(mainTarget)) {
                Entity entity = world.getEntity(mainTarget);
                if (mainTarget.equals(targetEat)) {
                    eat(world, entity);
                    System.out.println("I am eating..");
                } else {
                    attack(world, (Creature) entity);
                    System.out.println("I am attacking...");
                }
                return;
            }
            world.moveEntity(this, nextStep);
            checkCellEffects(world, nextStep);

        }
    }

    private Coordinates chooseTarget(Coordinates current, Coordinates targetEat, Coordinates targetAttack) {
        if (targetEat == null) return targetAttack;
        if (targetAttack == null) return targetEat;

        int distanceEat = Math.abs(targetEat.row() - current.row()) +
                Math.abs(targetEat.column() - current.column());
        int distanceAttack = Math.abs(targetAttack.row() - current.row()) +
                Math.abs(targetAttack.column() - current.column());

        return Integer.compare(distanceEat,distanceAttack) <= 0 ? targetEat : targetAttack;
    }

    protected void eat(WorldMap world, Entity food) {
        Coordinates foodPosition = world.getPosition(food);
        this.hunger -= food.powerSatiety;
        this.health += food.powerHealing;
        world.removeEntity(food);
        if (world.isPlaceEmpty(foodPosition)) {
            world.moveEntity(this, foodPosition);
        }
    }

    protected void attack(WorldMap world, Creature victim) {
            victim.health -= this.powerAttack;
            if (victim.health <= 0)
                if (this.hunger >= 50) {
                    eat(world, victim);
            } else {
                world.removeEntity(victim);
            }
    }

    protected abstract void checkCellEffects(WorldMap world, Coordinates nextStep);


}
