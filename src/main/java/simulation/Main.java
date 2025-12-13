package simulation;

import simulation.RendererWorldMap;
import simulation.entities.Inhabitant;

public class Main {
    public static void main(String[] args) {
        RendererWorldMap renderer = new RendererWorldMap();
        WorldMap map = new WorldMap(20, 20);
        Simulation sim = new Simulation(map);
        sim.start();

        renderer.printMap(map);


    }

}