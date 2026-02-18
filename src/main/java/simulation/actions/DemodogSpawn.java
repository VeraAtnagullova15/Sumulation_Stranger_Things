package simulation.actions;

import simulation.WorldMap;
import simulation.entities.Demodog;
import simulation.entities.Entity;

public class DemodogSpawn extends SpawnEntity {
    @Override
    protected int calculateSpawnEntity(WorldMap map) {
        return ((map.getHeight() * map.getWidth()) / 100) * PERCENT_DEMODOGS;
    }

    @Override
    public Entity createEntity() {
        return new Demodog();
    }
}
