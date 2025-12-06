package simulation.actions;

import simulation.WorldMap;

public class GateSpawn extends SpawnEntity {
    @Override
    protected int calculateSpawnEntity(WorldMap map) {
        return ((map.getHeight() * map.getWidth()) / 100) * PERCENT_GATES;
    }

    @Override
    protected void spawnEntity() {
        //TODO
    }
}
