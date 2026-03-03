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
    protected volatile boolean isPaused = false;
    protected final Object lock = new Object();
    protected volatile boolean isRunning = true;

    public Simulation() {
    }

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
        for (Action action : initActions) {
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
        while (!isPaused) {
            nextTurn();
            System.out.println(getCounterTurns());
        }
    }

    protected void pauseSimulation() {
        isPaused = true;
    }

    protected void restartSimulation() {
        synchronized (lock) {
            isPaused = false;
            lock.notify();
        }
    }


}





