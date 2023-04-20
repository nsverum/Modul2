import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
public abstract class Animal {
    private int x;
    private int y;
    private Type type;
    private int number;
    private int energy;
    private boolean isAlive;
    private Gender gender;

    public Animal(int energy, boolean isAlive, Type type) {
        this.energy = energy;
        this.isAlive = isAlive;
        this.gender = Gender.randomGender();
        this.type = type;
    }

    public abstract void eat(ConcurrentHashMap<Type, CopyOnWriteArrayList<Animal>> animalMap);
    boolean isHungry() {
        return getEnergy() < getType().getMaxEnergy();
    }

     public void moveTo(int nextX, int nextY, Animal animal) {
        animal.setX(nextX);
        animal.setY(nextY);
    }
    public Type getType() {
        return type;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Animal from " + getClass().toString() +
                ": x=" + x +
                ", y=" + y +
                ' ';
    }
}
