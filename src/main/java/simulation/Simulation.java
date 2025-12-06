package simulation;

public class Simulation {
    private WorldMap map;
    private RendererWorldMap renderer;

    public Simulation(WorldMap map) {
        this.map = map;
        renderer = new RendererWorldMap();
    }
}
