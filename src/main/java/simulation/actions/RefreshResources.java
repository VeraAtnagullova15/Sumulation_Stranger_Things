package simulation.actions;

import simulation.Coordinates;
import simulation.WorldMap;
import simulation.entities.*;

public class RefreshResources extends Action {

    @Override
    public void execute(WorldMap world) {
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
        if (countInhabitant <= 2) {
            Coordinates coordinates = world.getRandomEmptyPlace();
            Entity entity = new InhabitantSpawn().createEntity();
            world.setEntities(coordinates, entity);
        }
        if (countSoldier <= 2) {
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
}
