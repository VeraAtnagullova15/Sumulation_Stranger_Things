package simulation.actions;
import simulation.Coordinates;
import simulation.WorldMap;
import simulation.entities.Entity;

public abstract class SpawnEntity extends Action {
    protected final int PERCENT_INHABITANTS = 5;
    protected final int PERCENT_SOLDIERS = 3;
    protected final int PERCENT_DEMODOGS = 3;
    protected final int PERCENT_DEMOBATS = 3;
    protected final int PERCENT_RATION_BOXES = 5;
    protected final int PERCENT_SPORE_PATCHES = 3;
    protected final int PERCENT_GATES = 2;

    protected abstract int calculateSpawnEntity(WorldMap map);

    protected abstract Entity createEntity();

    public void spawnEntity(WorldMap map) {
        int numberEntities = calculateSpawnEntity(map);
        for (int i = 0; i < numberEntities; i++) {
            Coordinates coordinates = map.getRandomEmptyPlace();
            Entity entity = createEntity();
            map.setEntities(coordinates, entity);
        }
    }



}
