package simulation;

public class WalkMove implements MoveBehavior {
    @Override
    public boolean canPass(WorldMap world, Coordinates cell, Coordinates target) {
        return world.isPlaceEmpty(cell) || cell.equals(target);
    }
}
