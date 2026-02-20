package simulation;

import simulation.entities.Demogorgon;
import simulation.entities.Entity;
import simulation.entities.MapObject;

public class FlyMove implements MoveBehavior {
    @Override
    public boolean canPass(WorldMap world, Coordinates cell, Coordinates target) {
        if (cell.equals(target))return true;
        if (world.isPlaceEmpty(cell)) return true;
        Entity entity = world.getEntity(cell);
        if (entity instanceof MapObject) return true;
        return false;
    }
}
