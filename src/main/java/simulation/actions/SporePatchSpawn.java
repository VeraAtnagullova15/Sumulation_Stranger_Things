package simulation.actions;

import simulation.WorldMap;

public class SporePatchSpawn extends SpawnEntity {
    @Override
    protected int calculateSpawnEntity(WorldMap map) {
        return ((map.getHeight() * map.getWidth()) / 100) * PERCENT_SPORE_PATCHES;
    }

    @Override
    protected void spawnEntity() {
        //TODO
    }
}
