import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Herbivore extends Animal{
    public Herbivore(int energy, boolean isAlive, Type type) {
        super(energy, isAlive, type);
    }
    public void eat (Location location) {
        if (isHungry()) {
            if (location.getPlantVolume() > getType().getMaxEnergy()) {
                setEnergy((int) (getEnergy() + getType().getMaxEnergy()));
                location.setPlantVolume((int) (location.getPlantVolume() - getType().getMaxEnergy()));
               // System.out.println("Herbivore " + this + " is eating" + ", Кількість рослин = " + location.getPlantVolume());
            }
            else if (getEnergy() < 0){
                setAlive(false);

                location.getAnimalMap().values().remove(this);
             //  System.out.println("Herbivore " + this + " died"+ ", Кількість рослин = " + location.getPlantVolume());
                location.setNumAnimalsToDie(location.getNumAnimalsToDie() +1);

            }
        }

    }
}

