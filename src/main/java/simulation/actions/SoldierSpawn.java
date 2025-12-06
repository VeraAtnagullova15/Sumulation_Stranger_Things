package simulation.actions;

import simulation.WorldMap;

public class SoldierSpawn extends SpawnEntity {
    @Override
    protected int calculateSpawnEntity(WorldMap map) {
        return ((map.getHeight() * map.getWidth()) / 100) * PERCENT_SOLDIERS;
    }

    @Override
    protected void spawnEntity() {
        //TODO
    }
}
