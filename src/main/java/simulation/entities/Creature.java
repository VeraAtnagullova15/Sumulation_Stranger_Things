package simulation.entities;

import simulation.*;

import java.util.ArrayList;

public abstract class Creature extends Entity {
    protected int speed;
    protected int health;
    protected int hunger;
    protected int powerAttack;
    protected Class<? extends Entity> targetType;
    protected MoveBehavior moveBehavior;

    public Creature(Class<? extends Entity> targetType, MoveBehavior moveBehavior) {
        this.targetType = targetType;
        this.moveBehavior = moveBehavior;
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

    public void makeMove(WorldMap world, BFS bfs) {System.out.println("\n=== MAKEMOVE START для " + this.getClass().getSimpleName() + " ===");
        System.out.println("Моя позиция в начале хода: " + world.getPosition(this));
        Coordinates target = findTarget(world, targetType);
        if (target == null) return;
        for (int i = 0; i < speed; i++) {
            Coordinates current = world.getPosition(this);
            if (current.equals(target)) {
                Entity food = world.getEntity(target);
                eat(world, food);
                return;
            }
            Coordinates nextStep = bfs.findPath(world, this.moveBehavior, current, target);
            if (nextStep == null) {
                return;
            }
            if (nextStep.equals(target)) {
                Entity food = world.getEntity(target);
                eat(world, food);
                return;
            }
            world.moveEntity(this, nextStep);
        }
    }

//    protected Coordinates chooseNextStep(Coordinates from, Coordinates to, WorldMap world) {
//        Coordinates upCell = new Coordinates(from.row() - 1, from.column());
//        Coordinates lowCell = new Coordinates(from.row() + 1, from.column());
//        Coordinates rightCell = new Coordinates(from.row(), from.column() + 1);
//        Coordinates leftCell = new Coordinates(from.row(), from.column() - 1);
//        ArrayList<Coordinates> availableCells = new ArrayList<>();
//        if (world.isPlaceInside(upCell) && world.isPlaceEmpty(upCell)) availableCells.add(upCell);
//        if (world.isPlaceInside(lowCell) && world.isPlaceEmpty(lowCell)) availableCells.add(lowCell);
//        if (world.isPlaceInside(rightCell) && world.isPlaceEmpty(rightCell)) availableCells.add(rightCell);
//        if (world.isPlaceInside(leftCell) && world.isPlaceEmpty(leftCell)) availableCells.add(leftCell);
//
//        int minimalDistance = Integer.MAX_VALUE;
//        Coordinates nextStep = from;
//
//        for (int i = 0; i < availableCells.size(); i++) {
//            int distance = Math.abs(to.row() - availableCells.get(i).row()) +
//                    Math.abs(to.column() - availableCells.get(i).column());
//            if (distance < minimalDistance) {
//                minimalDistance = distance;
//                nextStep = availableCells.get(i);
//            }
//        }
//        return nextStep;
//    }

    protected void eat(WorldMap world, Entity food) {
        System.out.println("=== EAT START ===");
        System.out.println("Моя позиция ДО еды: " + world.getPosition(this));
        System.out.println("Позиция еды: " + world.getPosition(food));
        Coordinates foodPosition = world.getPosition(food);
        this.hunger -= food.powerSatiety;
        this.health += food.powerHealing;
        world.removeEntity(food);
        System.out.println("Еда удалена. Клетка пустая? " + world.isPlaceEmpty(foodPosition));
        if (world.isPlaceEmpty(foodPosition)) {
            System.out.println("Пытаюсь переместиться на: " + foodPosition);
            world.moveEntity(this, foodPosition);
            System.out.println("Моя позиция ПОСЛЕ перемещения: " + world.getPosition(this));
        } else {
            System.out.println("Клетка НЕ пустая, не перемещаюсь!");
        }
        System.out.println("=== EAT END ===");
    }


}
