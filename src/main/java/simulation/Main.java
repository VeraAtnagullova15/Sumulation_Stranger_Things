package simulation;


public class Main {
    public static void main(String[] args) {
        RendererWorldMap renderer = new RendererWorldMap();
        WorldMap world = new WorldMap(10, 10);
        Simulation sim = new Simulation(world);
        sim.start();
        renderer.printMap(world);

        try {
            Thread.sleep(2000); // Пауза перед началом
        } catch (InterruptedException e) {
            return;
        }

        for (int i = 0; i < 20; i++) {
            sim.tick();
            renderer.printMap(world);
            sim.refreshResources();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }


}