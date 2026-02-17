package simulation;

public class FlyMove implements MoveBehavior {
    @Override
    public boolean canPass(WorldMap world, Coordinates cell, Coordinates target) {
        return true;
    }
}
