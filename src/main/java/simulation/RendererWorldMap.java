package simulation;

import simulation.entities.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class RendererWorldMap {

    private static final String REGULAR_BACKGROUD = "\u001B[46;5;107m";
    private static final String WARNING_BACKGROUND = "\u001B[48;5;214m";
    private static final String DANGER_BACKGROUND = "\u001B[48;5;160m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String EMPTY_SPACE = "•";
    private static final String DEMODOG = "\uD83D\uDC3A";
    private static final String INHABITANT = "\uD83D\uDC68";
    private static final String DEMOBAT = "\uD83E\uDD87";
    private static final String SOLDIER = "\uD83D\uDC6E";
    private static final String GATE = "\uD83D\uDEAA";
    private static final String RATION_BOX = "\uD83C\uDF54";
    private static final String SPORE_PATCH = "\uD83D\uDCAD";
    private static final String CLEAR_SCREEN = "\033[2J\033[1;1H";
    private static final String MOVE_CURSOR_HOME = "\033[H";

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

    protected String getBackgroundColor(Entity entity) {
        if (entity instanceof Creature creature) {
            if (creature.getHealth() <= 25 || creature.getHunger() >= 75) {
                return DANGER_BACKGROUND;
            } else if (creature.getHealth() <= 40 || creature.getHunger() >= 60){
                return WARNING_BACKGROUND;
            }
        }
        return REGULAR_BACKGROUD;
    }

    protected void printMap(WorldMap map) {
        System.out.println(CLEAR_SCREEN);
        System.out.flush();
        for (int i = 0; i < map.getHeight(); i++) {
            StringBuilder line = new StringBuilder("");
            for (int j = 0; j < map.getWidth(); j++) {
                Coordinates coordinates = new Coordinates(i, j);
                Entity entity = map.getEntity(coordinates);
                String background = getBackgroundColor(entity);
                line.append(background).append(String.format("%-4s", getSymbolEntities(entity))).append(ANSI_RESET);
            }
            System.out.println(line);
        }
    }

}

