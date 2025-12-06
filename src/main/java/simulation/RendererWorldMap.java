package simulation;
public class RendererWorldMap {

    private static final String REGULAR_BACKGROUD = "\u001B[48;5;144m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String DEMODOG = "W";

    private void printMap(WorldMap map) {
        for (int i = 1; i <= map.getHeight(); i++) {
            for (int j = 1; j <= map.getWidth(); j++) {
                System.out.print(DEMODOG);
            }
            System.out.println("\u001B[0m");
        }
    }

}

