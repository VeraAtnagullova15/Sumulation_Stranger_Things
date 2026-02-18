package simulation.actions;

import simulation.WorldMap;
import simulation.entities.Entity;
import simulation.entities.RationBox;

public class RationBoxSpawn extends SpawnEntity {
    @Override
    protected int calculateSpawnEntity(WorldMap map) {
        return ((map.getHeight() * map.getWidth()) / 100) * PERCENT_RATION_BOXES;
    }

    @Override
    public Entity createEntity() {
        return new RationBox();
    }
}
