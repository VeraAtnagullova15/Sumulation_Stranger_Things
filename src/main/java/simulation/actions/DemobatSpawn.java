package simulation.actions;

import simulation.WorldMap;
import simulation.entities.Demobat;
import simulation.entities.Entity;

public class DemobatSpawn extends SpawnEntity {
    @Override
    protected int calculateSpawnEntity(WorldMap map) {
        return ((map.getHeight() * map.getWidth()) / 100) * PERCENT_DEMOBATS;
    }

    @Override
    protected Entity createEntity() {
        return new Demobat();
    }
}
