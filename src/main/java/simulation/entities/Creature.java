package simulation.entities;

import simulation.Coordinates;
import simulation.WorldMap;

import java.util.ArrayList;

public abstract class Creature extends Entity {
    protected int speed;
    protected int health;
    protected int hunger;
    protected int powerAttack;
    protected Entity target;
    WorldMap world;

    public Creature() {
    }

    protected Coordinates findTarget(WorldMap world, Class <? extends Entity> target) {
        Coordinates myCoordinates = world.getPosition(this);
        int minimalDistance = Integer.MAX_VALUE;
        Coordinates targetCoordinates = null;
        for (Entity entity : world.getEntitiesToCoordinates().keySet()) {
            if (target.isInstance(entity)) {
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

    protected abstract void makeMove(WorldMap world);

    protected Coordinates chooseNextStep(Coordinates from, Coordinates to, WorldMap world) {
        Coordinates upCell = new Coordinates(from.row() - 1, from.column());
        Coordinates lowCell = new Coordinates(from.row() + 1, from.column());
        Coordinates rightCell = new Coordinates(from.row(), from.column() + 1);
        Coordinates leftCell = new Coordinates(from.row(), from.column() - 1);
        ArrayList<Coordinates> availableCells = new ArrayList<>();
        if (world.isPlaceInside(upCell) || world.isPlaceEmpty(upCell)) availableCells.add(upCell);
        if (world.isPlaceInside(lowCell) || world.isPlaceEmpty(lowCell)) availableCells.add(lowCell);
        if (world.isPlaceInside(rightCell) || world.isPlaceEmpty(rightCell)) availableCells.add(rightCell);
        if (world.isPlaceInside(leftCell) || world.isPlaceEmpty(leftCell)) availableCells.add(leftCell);

        int minimalDistance = Integer.MAX_VALUE;
        Coordinates nextStep = from;

        for (int i = 0; i < availableCells.size(); i++) {
            int distance = Math.abs(to.row() - availableCells.get(i).row()) +
                    Math.abs(to.column() - availableCells.get(i).column());
            if (distance < minimalDistance) {
                minimalDistance = distance;
                nextStep = availableCells.get(i);
            }
        }
        return nextStep;
    }

}
