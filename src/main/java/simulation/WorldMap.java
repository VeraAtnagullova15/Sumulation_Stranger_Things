package simulation;
import simulation.entities.*;
import java.util.HashMap;
import java.util.Random;
import simulation.Coordinates;


public class WorldMap {
    private int height;
    private int width;

    Random random = new Random();

    public WorldMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    HashMap<Coordinates, Entity> coordinatesToEntities = new HashMap<>();
    HashMap<Entity, Coordinates> entitiesToCoordinates = new HashMap<>();


    public void setEntities(Coordinates coordinates, Entity entity) {
        coordinatesToEntities.put(coordinates, entity);
        entitiesToCoordinates.put(entity, coordinates);
    }

    public boolean isPlaceEmpty(Coordinates coordinates) {
        return !coordinatesToEntities.containsKey(coordinates);
    }

    public boolean isPlaceInside(Coordinates coordinates) {
        return coordinates.row() >= 0 && coordinates.row() < height &&
                coordinates.column() >= 0 && coordinates.column() < width;
    }

    public boolean canMoveTo(Coordinates coordinates) {
        return isPlaceEmpty(coordinates) && isPlaceInside(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return coordinatesToEntities.get(coordinates);
    }

    public Coordinates getPosition(Entity entity) {
        return entitiesToCoordinates.get(entity);
    }

    public void removeEntity(Entity entity) {
        Coordinates coordinates = entitiesToCoordinates.get(entity);
        coordinatesToEntities.remove(coordinates);
        entitiesToCoordinates.remove(entity);
    }

    public void moveEntity(Entity entity, Coordinates newCoordinates) {
        if (isPlaceEmpty(newCoordinates)){
            Coordinates oldCoordinates = entitiesToCoordinates.get(entity);
            coordinatesToEntities.remove(oldCoordinates);
            entitiesToCoordinates.remove(entity);
            coordinatesToEntities.put(newCoordinates, entity);
            entitiesToCoordinates.put(entity, newCoordinates);
        }
    }

    public Coordinates getRandomEmptyPlace() {
        while(true) {
            int row = random.nextInt(height);
            int column = random.nextInt(width);
            Coordinates coordinates = new Coordinates(row, column);

            if (isPlaceEmpty(coordinates)) return coordinates;
        }
    }

}
