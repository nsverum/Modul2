import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public enum Type {
    WOLF (8,50,3,30,'W'),
    FOX(2,8,2,30,'F'),
    SHEEP(15,70,3,30,'S'),
    HORSE(60,400,4,30,'H'),
    BEAR(80,500,2,3,'B');

    private int maxEnergy;
    private int weight;
    private int speed;
    private int maxPerCell;
    private char picture;
    private Map<Type, Integer> ration;

    Type(int maxEnergy, int weight, int speed, int maxPerCell, char picture) {
        this.maxEnergy = maxEnergy;
        this.weight = weight;
        this.speed = speed;
        this.maxPerCell = maxPerCell;
        this.picture = picture;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxPerCell() {
        return maxPerCell;
    }

    public void setMaxPerCell(int maxPerCell) {
        this.maxPerCell = maxPerCell;
    }

    public char getPicture() {
        return picture;
    }

    public void setPicture(char picture) {
        this.picture = picture;
    }

    public Map<Type, Integer> getRation() {
        if (ration == null){
            ration = PosFactory.ration(this);
        }

        return ration;
    }

    public void setRation(Map<Type, Integer> ration) {
        this.ration = ration;
    }
}
