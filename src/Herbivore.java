import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Herbivore extends Animal{
    public Herbivore(int energy, boolean isAlive, Type type) {
        super(energy, isAlive, type);
    }
    public void eat (ConcurrentHashMap<Type, CopyOnWriteArrayList<Animal>> animalMap) {
        if (isHungry()) {
            setEnergy((int) (getEnergy() *2));
            System.out.println("Herbivore " + this + " is eating");
        }
    }
}

