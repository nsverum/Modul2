import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Herbivore extends Animal{
    public Herbivore(int energy, boolean isAlive, Type type) {
        super(energy, isAlive, type);
    }
    public void eat (Location location) {
        ConcurrentHashMap<Type, CopyOnWriteArrayList<Animal>> animalMap = location.getAnimalMap();
        if (isHungry()) {
            if (location.getPlantVolume() > getType().getMaxEnergy()) {
                setEnergy((int) (getEnergy() + getType().getMaxEnergy()));
                location.setPlantVolume((int) (location.getPlantVolume() - getType().getMaxEnergy()));
               // System.out.println("Herbivore " + this + " is eating" + ", Кількість рослин = " + location.getPlantVolume());
            }
            else {
                int maxValueFromRation = 1;
                Map.Entry<Type, CopyOnWriteArrayList<Animal>> bestForEat = null;
                for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : animalMap.entrySet()){
                    if (!entry.getValue().isEmpty()){
                        int ValueFromRation = getType().getRation().get(entry.getKey());
                        if(ValueFromRation > maxValueFromRation) {
                            maxValueFromRation = ValueFromRation;
                            bestForEat = entry;
                        }
                    }
                }
                if (bestForEat != null && !bestForEat.getValue().isEmpty()) {
                    setEnergy((int) (getEnergy() + bestForEat.getKey().getWeight()));
                    //  System.out.println("Всеядний " + this + "is eating " + bestForEat.getValue().get(0));
                    bestForEat.getValue().remove(bestForEat.getValue().size() - 1);
                    location.setNumAnimalsToDie(location.getNumAnimalsToDie() + 1);
                }
                else if (getEnergy() < 0){
                    setAlive(false);
                    location.getAnimalMap().values().remove(this);
                    location.setNumAnimalsToDie(location.getNumAnimalsToDie() + 1);
                   //   System.out.println("Herbivore " + this + " died of hunger " );

                }
            }
//            else if (getEnergy() < 0){
//                setAlive(false);
//
//                location.getAnimalMap().values().remove(this);
//             //  System.out.println("Herbivore " + this + " died"+ ", Кількість рослин = " + location.getPlantVolume());
//                location.setNumAnimalsToDie(location.getNumAnimalsToDie() +1);
//            }
        }

    }
}

