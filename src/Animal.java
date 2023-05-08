import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
public abstract class Animal {
    private Type type;
    private int number;
    private int energy;
    private boolean isAlive;
    private Gender gender;
    private Location currentLocation;
    private Location newLocation;
    public Animal(int energy, boolean isAlive, Type type) {
        this.energy = energy;
        this.isAlive = isAlive;
        this.gender = Gender.randomGender();
        this.type = type;
    }

    public abstract void eat(Location location);
    boolean isHungry() {
        return getEnergy() < getType().getMaxEnergy();
    }
    public void move(){
        if (newLocation != null && newLocation.isFree(this)) {
            currentLocation.removeAnimal(this);
            newLocation.addAnimal(this);
            currentLocation = newLocation;
            setEnergy(getEnergy() - 1);
        }
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

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Animal from " + getClass().toString() +
                ": x=" + currentLocation.getX() +
                ", y=" + currentLocation.getY() +
                ' ';
    }
}
