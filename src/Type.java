import java.util.HashMap;
import java.util.Map;

public enum Type {
    WOLF (50,8,50,3,30,'^',
            new HashMap<Type, Integer>(){{ put(Type.WOLF, 0); }{ put(Type.FOX, 0); }{ put(Type.SHEEP, 70); }{ put(Type.HORSE, 10); }{ put(Type.BEAR, 0); }}),
    FOX(50,8,8,2,30,'F',
            new HashMap<Type, Integer>(){{ put(Type.WOLF, 0); }{ put(Type.FOX, 0); }{ put(Type.SHEEP, 0); }{ put(Type.HORSE, 0); { put(Type.BEAR, 0); }}}),
    SHEEP(50,8,70,3,30,'S',
            new HashMap<Type, Integer>(){{ put(Type.WOLF, 0); }{ put(Type.FOX, 0); }{ put(Type.SHEEP, 0); }{ put(Type.HORSE, 0); }{ put(Type.BEAR, 0); }}),
    HORSE(50,8,400,4,30,'H',
            new HashMap<Type, Integer>(){{ put(Type.WOLF, 0); }{ put(Type.FOX, 0); }{ put(Type.SHEEP, 0); }{ put(Type.HORSE, 0); }{ put(Type.BEAR, 0); }}),
    BEAR(50,80,500,2,3,'B',
            new HashMap<Type, Integer>(){{ put(Type.WOLF, 0); }{ put(Type.FOX, 0); }{ put(Type.SHEEP, 70); }{ put(Type.HORSE, 40); }{ put(Type.BEAR, 0); }});

    private int energy; // уровень энергии животного
    private int maxEnergy; // Сколько килограммов пищи нужно животному для полного насыщения
    private int weight; // вес животного
    private int speed; // не более чем, клеток за ход
    private int maxPerCell; // максимальное количество животных этого вида на одной клетке
    private char picture; // як виглядає

    Map<Type, Integer> ration;
    // данні з таблиці насищення
    Type(int energy, int maxEnergy, int weight, int speed, int maxPerCell, char picture, Map<Type, Integer> ration) {

        this.energy = energy;
        this.maxEnergy = maxEnergy;
        this.weight = weight;
        this.speed = speed;
        this.maxPerCell = maxPerCell;
        this.picture = picture;
        this.ration = ration;
        }


    public char picture() {
        return picture;
    }


    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
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




}
