package simulation;
import simulation.entities.*;
import java.util.HashMap;
import java.util.Random;
import simulation.Coordinates;


public class WorldMap {
    private int height;
    private int width;

    protected HashMap<Coordinates, Entity> coordinatesToEntities = new HashMap<>();
    protected HashMap<Entity, Coordinates> entitiesToCoordinates = new HashMap<>();

    public WorldMap(int height, int width) {
        this.height = height;
        this.width = width;
    }
    Random random = new Random();

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    public HashMap<Entity, Coordinates> getEntitiesToCoordinates() {
        return entitiesToCoordinates;
    }

    public HashMap<Coordinates, Entity> getCoordinatesToEntities() {
        return coordinatesToEntities;
    }

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
