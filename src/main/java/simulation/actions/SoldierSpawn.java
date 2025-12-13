package simulation.actions;

import simulation.WorldMap;
import simulation.entities.Entity;
import simulation.entities.Soldier;

public class SoldierSpawn extends SpawnEntity {
    @Override
    protected int calculateSpawnEntity(WorldMap map) {
        return ((map.getHeight() * map.getWidth()) / 100) * PERCENT_SOLDIERS;
    }

    @Override
    protected Entity createEntity() {
        return new Soldier();
    }

}
