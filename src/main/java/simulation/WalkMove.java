package simulation;

import simulation.entities.Entity;
import simulation.entities.Gate;
import simulation.entities.SporePatch;

public class WalkMove implements MoveBehavior {
    @Override
    public boolean canPass(WorldMap world, Coordinates cell, Coordinates target) {
        Entity entity = world.getEntity(cell);
        if (entity instanceof SporePatch || entity instanceof Gate) return true;
        return world.isPlaceEmpty(cell) || cell.equals(target);
    }
}
