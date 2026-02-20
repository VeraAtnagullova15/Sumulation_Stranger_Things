package simulation;

import simulation.actions.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

private WorldMap world;
private RendererWorldMap renderer;
private int counterTurns;
private List<Action> initActions;
private List<Action> turnActions;

    public Simulation(WorldMap world) {
        this.world = world;
        renderer = new RendererWorldMap();
        counterTurns = 0;
        initActions = new ArrayList<>();
        turnActions = new ArrayList<>();

        initActions.add(new GateSpawn());
        initActions.add(new SporePatchSpawn());
        initActions.add(new RationBoxSpawn());
        initActions.add(new InhabitantSpawn());
        initActions.add(new SoldierSpawn());
        initActions.add(new DemobatSpawn());
        initActions.add(new DemodogSpawn());

        turnActions.add(new MoveCreature());
        turnActions.add(new RefreshResources());
    }

    public int getCounterTurns() {
        return counterTurns;
    }

    protected void start() {
        for (Action action: initActions) {
            action.execute(world);
        }
        renderer.printMap(world);
    }

    protected void nextTurn() {
        counterTurns++;
        for (Action action : turnActions) {
            action.execute(world);
        }
        renderer.printMap(world);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
    }

    protected void startSimulation() {
        boolean isPause = false;
        start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }

        while (!isPause) {
            nextTurn();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    protected void pauseSimulation() {
        //  to do
    }


}





