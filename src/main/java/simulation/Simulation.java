package simulation;

import simulation.actions.*;
import simulation.entities.*;

import java.util.ArrayList;


public class Simulation {
    private WorldMap world;
    private RendererWorldMap renderer;
    private BFS bfs;
    private MoveBehavior moveBehavior;

    public Simulation(WorldMap world) {
        this.world = world;
        renderer = new RendererWorldMap();
        bfs = new BFS();
    }

    protected void start() {
        SpawnEntity[] spawnEntities = {new InhabitantSpawn(), new SoldierSpawn(), new DemodogSpawn(),
                new DemobatSpawn(), new GateSpawn(), new SporePatchSpawn(), new RationBoxSpawn()};

        for (SpawnEntity se : spawnEntities) {
            se.spawnEntity(world);
        }
    }

    protected void refreshResources() {
        int countInhabitant = 0;
        int countSoldier = 0;
        int countDemobat = 0;
        int countDemodog = 0;
        int countRation = 0;
        for (Entity entity : world.getEntitiesToCoordinates().keySet()) {
            if (entity instanceof Inhabitant) countInhabitant++;
            else if (entity instanceof Soldier) countSoldier++;
            else if (entity instanceof Demobat) countDemobat++;
            else if (entity instanceof Demodog) countDemodog++;
            else if (entity instanceof RationBox) countRation++;
        }
        if (countInhabitant <= 1) {
            Coordinates coordinates = world.getRandomEmptyPlace();
            Entity entity = new InhabitantSpawn().createEntity();
            world.setEntities(coordinates, entity);
        }
        if (countSoldier <= 1) {
            Coordinates coordinates = world.getRandomEmptyPlace();
            Entity entity = new SoldierSpawn().createEntity();
            world.setEntities(coordinates, entity);
        }
        if (countDemobat <= 1) {
            Coordinates coordinates = world.getRandomEmptyPlace();
            Entity entity = new DemobatSpawn().createEntity();
            world.setEntities(coordinates, entity);
        }
        if (countDemodog <= 1) {
            Coordinates coordinates = world.getRandomEmptyPlace();
            Entity entity = new DemodogSpawn().createEntity();
            world.setEntities(coordinates, entity);
        }
        if (countRation <= 2) {
            Coordinates coordinates = world.getRandomEmptyPlace();
            Entity entity = new RationBoxSpawn().createEntity();
            world.setEntities(coordinates, entity);
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
            if (world.getPosition(creature) != null) {
                creature.makeMove(world, bfs);
            }
        }
    }
}
