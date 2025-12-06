package simulation.actions;

import simulation.WorldMap;

public class DemodogSpawn extends SpawnEntity {
    @Override
    protected int calculateSpawnEntity(WorldMap map) {
        return ((map.getHeight() * map.getWidth()) / 100) * PERCENT_DEMODOGS;
    }

    @Override
    protected void spawnEntity() {
        //TODO
    }
}
