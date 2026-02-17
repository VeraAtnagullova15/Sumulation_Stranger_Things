package simulation;

public interface MoveBehavior {
    boolean canPass (WorldMap world, Coordinates cell, Coordinates target);
}
