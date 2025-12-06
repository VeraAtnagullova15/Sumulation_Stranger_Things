package simulation.actions;

import simulation.WorldMap;

public class RationBoxSpawn extends SpawnEntity {
    @Override
    protected int calculateSpawnEntity(WorldMap map) {
        return ((map.getHeight() * map.getWidth()) / 100) * PERCENT_RATION_BOXES;
    }

    @Override
    protected void spawnEntity() {
        //TODO
    }
}
