package simulation.actions;

import simulation.WorldMap;
import simulation.entities.Entity;
import simulation.entities.Gate;

public class GateSpawn extends SpawnEntity {
    @Override
    protected int calculateSpawnEntity(WorldMap map) {
        return ((map.getHeight() * map.getWidth()) / 100) * PERCENT_GATES;
    }

    @Override
    protected Entity createEntity() {
        return new Gate();
    }
}
