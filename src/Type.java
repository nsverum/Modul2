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
    RABBIT(0.45,2,2,15,'R'),

    BEAR(80,500,2,3,'B'),
    SNAKE(3,15,1,30,'S'),
    EAGLE(1,6,3,20,'E'),
    DEER(50,300, 4, 20, 'D'),
    GOAT(10,60,3,140,'G'),
    BOAR(50,400,2,50,'B'),
    BUFFALO(100, 700, 3,10,'B'),
    DUCK(0.15, 1, 4,200,'D'),
    CATERPILLAR(0,0.01,0,1000,'C');



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
    public Map<Type, Integer> getRation() {
        if (ration == null){
            ration = PosFactory.ration(this);
        }

        return ration;
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



    public void setRation(Map<Type, Integer> ration) {
        this.ration = ration;
    }
}
