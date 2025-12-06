package simulation.actions;

import simulation.WorldMap;

public class DemobatSpawn extends SpawnEntity {
    @Override
    protected int calculateSpawnEntity(WorldMap map) {
        return ((map.getHeight() * map.getWidth()) / 100) * PERCENT_DEMOBATS;
    }

    @Override
    protected void spawnEntity() {
        //TODO
    }
}
