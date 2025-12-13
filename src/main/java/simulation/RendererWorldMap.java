package simulation;

import simulation.entities.*;

public class RendererWorldMap {

    private static final String REGULAR_BACKGROUD = "\u001B[48;5;153m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String EMPTY_SPACE = "•";
    private static final String DEMODOG = "\uD83D\uDC3A";
    private static final String INHABITANT = "\uD83D\uDEB6";
    private static final String DEMOBAT = "\uD83E\uDD87";
    private static final String SOLDIER = "\uD83D\uDC6E";
    private static final String GATE = "\uD83D\uDEAA";
    private static final String RATION_BOX = "\uD83C\uDF54";
    private static final String SPORE_PATCH = "\uD83D\uDCAD";

    private String getSymbolEntities(Entity entity) {
        if (entity instanceof Inhabitant) return INHABITANT;
        if (entity instanceof Soldier) return SOLDIER;
        if (entity instanceof Demodog) return DEMODOG;
        if (entity instanceof Demobat) return DEMOBAT;
        if (entity instanceof RationBox) return RATION_BOX;
        if (entity instanceof Gate) return GATE;
        if (entity instanceof SporePatch) return SPORE_PATCH;
        return EMPTY_SPACE;

    }

    protected void printMap(WorldMap map) {
        for (int i = 0; i < map.getHeight(); i++) {
            StringBuilder line = new StringBuilder("");
            for (int j = 0; j < map.getWidth(); j++) {
                Coordinates coordinates = new Coordinates(i, j);
                Entity entity = map.getEntity(coordinates);
                line.append(REGULAR_BACKGROUD).append(String.format("%-4s", getSymbolEntities(entity))).append(ANSI_RESET);
            }
            System.out.println(line);
        }
    }

}

