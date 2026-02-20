package simulation.actions;

import simulation.BFS;
import simulation.WorldMap;
import simulation.entities.Creature;
import simulation.entities.Entity;

import java.util.ArrayList;

public class MoveCreature extends Action {
    private BFS bfs;

    public MoveCreature() {
        this.bfs = new BFS();
    }

    @Override
    public void execute(WorldMap world) {
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
