package simulation.actions;
import simulation.Coordinates;
import simulation.WorldMap;
import simulation.entities.Entity;

public abstract class SpawnEntity extends Action {
    protected final int PERCENT_INHABITANTS = 5;
    protected final int PERCENT_SOLDIERS = 4;
    protected final int PERCENT_DEMODOGS = 3;
    protected final int PERCENT_DEMOBATS = 3;
    protected final int PERCENT_RATION_BOXES = 5;
    protected final int PERCENT_SPORE_PATCHES = 5;
    protected final int PERCENT_GATES = 6;

    protected abstract int calculateSpawnEntity(WorldMap map);

    protected abstract Entity createEntity();

    public void spawnEntity(WorldMap world) {
        int numberEntities = calculateSpawnEntity(world);
        for (int i = 0; i < numberEntities; i++) {
            Coordinates coordinates = world.getRandomEmptyPlace();
            Entity entity = createEntity();
            world.setEntities(coordinates, entity);
        }
    }

    @Override
    public void execute(WorldMap world) {
        spawnEntity(world);
    }
}
