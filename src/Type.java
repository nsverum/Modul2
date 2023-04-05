import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public enum Type {
    WOLF (8,50,3,30,'W'),
    FOX(2,8,2,30,'F'),
    SHEEP(15,70,3,30,'S'),
    HORSE(60,400,4,30,'H'),
    MOUSE(0.01,0.05,1,500,'M'),
    RABBIT(0.45,2,2,150,'R'),

    BEAR(80,500,2,3,'B');


    private double maxEnergy;
    private double weight;
    private int speed;
    private int maxPerCell;
    private char picture;
    private Map<Type, Integer> ration;

    Type(double maxEnergy, double weight, int speed, int maxPerCell, char picture) {
        this.maxEnergy = maxEnergy;
        this.weight = weight;
        this.speed = speed;
        this.maxPerCell = maxPerCell;
        this.picture = picture;
    }

    public double getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public double getWeight() {
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
