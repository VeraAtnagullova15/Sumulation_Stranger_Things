package simulation;


public class Main {
    public static void main(String[] args) {
        RendererWorldMap renderer = new RendererWorldMap();
        WorldMap world = new WorldMap(10, 10);
        Simulation simulation = new Simulation(world);

        simulation.start();

        for (int i = 0; i < 20; i++) {
            simulation.nextTurn();
            System.out.println(simulation.getCounterTurns());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                break;
//            }
        }

//        simulation.startSimulation();


    }
}