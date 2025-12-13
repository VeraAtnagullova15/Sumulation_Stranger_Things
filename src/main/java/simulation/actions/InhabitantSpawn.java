package simulation.actions;

import simulation.WorldMap;
import simulation.entities.Entity;
import simulation.entities.Inhabitant;

public class InhabitantSpawn extends SpawnEntity {
    @Override
    protected int calculateSpawnEntity(WorldMap map) {
        return ((map.getHeight() * map.getWidth()) / 100) * PERCENT_INHABITANTS;
    }

    @Override
    protected Entity createEntity() {
        return new Inhabitant();
    }

//    @Override
//    void execute(WorldMap map) {
//        //TODO
//    }
}
