package simulation;

import simulation.actions.*;
import simulation.entities.Entity;

public class Simulation {
    private WorldMap map;
    private RendererWorldMap renderer;

    public Simulation(WorldMap map) {
        this.map = map;
        renderer = new RendererWorldMap();
    }

    protected void start() {

        SpawnEntity[] spawnEntities = {new InhabitantSpawn(), new SoldierSpawn(), new DemodogSpawn(),
                new DemobatSpawn(), new GateSpawn(), new SporePatchSpawn(), new RationBoxSpawn()};

        for (SpawnEntity se : spawnEntities) {
            se.spawnEntity(map);
        }
    }

}
