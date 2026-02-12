package simulation;

import simulation.actions.*;
import simulation.entities.Creature;
import simulation.entities.Entity;

import java.util.ArrayList;


public class Simulation {
    private WorldMap world;
    private RendererWorldMap renderer;

    public Simulation(WorldMap world) {
        this.world = world;
        renderer = new RendererWorldMap();
    }

    protected void start() {
        SpawnEntity[] spawnEntities = {new InhabitantSpawn(), new SoldierSpawn(), new DemodogSpawn(),
                new DemobatSpawn(), new GateSpawn(), new SporePatchSpawn(), new RationBoxSpawn()};

        for (SpawnEntity se : spawnEntities) {
            se.spawnEntity(world);
        }
    }

    protected void tick() {
        ArrayList<Creature> creatures = new ArrayList<>();
        for (Entity entity : world.getEntitiesToCoordinates().keySet()) {
            if (entity instanceof Creature creature) {
                creatures.add(creature);
            }
        }
        for (Creature creature : creatures) {
            creature.makeMove(world);
        }
    }
}
