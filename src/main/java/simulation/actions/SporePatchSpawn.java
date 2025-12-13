package simulation.actions;

import simulation.WorldMap;
import simulation.entities.Entity;
import simulation.entities.SporePatch;

public class SporePatchSpawn extends SpawnEntity {
    @Override
    protected int calculateSpawnEntity(WorldMap map) {
        return ((map.getHeight() * map.getWidth()) / 100) * PERCENT_SPORE_PATCHES;
    }

    @Override
    protected Entity createEntity() {
        return new SporePatch();
    }
}
