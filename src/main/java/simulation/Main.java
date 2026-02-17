package simulation;


public class Main {
    public static void main(String[] args) {
        RendererWorldMap renderer = new RendererWorldMap();
        WorldMap world = new WorldMap(10, 10);
        Simulation sim = new Simulation(world);
        sim.start();

        renderer.printMap(world);
        System.out.println();

        for (int i = 0; i < 3; i++) {
            sim.tick();
            renderer.printMap(world);
            System.out.println();
        }

    }


}