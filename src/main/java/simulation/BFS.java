package simulation;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class BFS {

    public Coordinates findPath(WorldMap world, MoveBehavior moveBehavior, Coordinates start, Coordinates finish) {
        Queue<Coordinates> neighbors = new ArrayDeque<>();
        Map<Coordinates, Coordinates> path = new HashMap<>();

        neighbors.add(start);
        path.put(start, null);

        while (!neighbors.isEmpty()) {

            Coordinates current = neighbors.poll();
            if (current.equals(finish)) {
                Coordinates nextStep = finish;
                Coordinates parent = path.get(nextStep);
                while (parent != null && !parent.equals(start)) {
                    nextStep = parent;
                    parent = path.get(nextStep);
                }
                return nextStep;
            }

            Coordinates upCell = new Coordinates(current.row() - 1, current.column());
            Coordinates lowCell = new Coordinates(current.row() + 1, current.column());
            Coordinates rightCell = new Coordinates(current.row(), current.column() + 1);
            Coordinates leftCell = new Coordinates(current.row(), current.column() - 1);

            if (world.isPlaceInside(upCell) && moveBehavior.canPass(world, upCell, finish)
                    && !path.containsKey(upCell)){
                neighbors.add(upCell);
                path.put(upCell, current);
            }
            if (world.isPlaceInside(lowCell) && moveBehavior.canPass(world, lowCell, finish)
                    && !path.containsKey(lowCell)){
                neighbors.add(lowCell);
                path.put(lowCell, current);
            }
            if (world.isPlaceInside(rightCell) && moveBehavior.canPass(world, rightCell, finish)
                    && !path.containsKey(rightCell)){
                neighbors.add(rightCell);
                path.put(rightCell, current);
            }
            if (world.isPlaceInside(leftCell) && moveBehavior.canPass(world, leftCell, finish)
                    && !path.containsKey(leftCell)){
                neighbors.add(leftCell);
                path.put(leftCell, current);
            }
        }
        return null;
    }
}
