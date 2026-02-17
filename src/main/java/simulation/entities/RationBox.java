package simulation.entities;

import simulation.Coordinates;

public class RationBox extends MapObject {
    public RationBox() {
        powerInfluenceToEntity = POWER_SATIETY_FOOD;
        powerHealing = POWER_HEALING_FOOD;
    }
}
