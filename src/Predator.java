import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Predator extends Animal {

    public Predator(int energy, boolean isAlive, Type type) {
        super(energy, isAlive, type);
    }
    public void eat (ConcurrentHashMap<Type, CopyOnWriteArrayList<Animal>> animalMap) {
        if (isHungry()) {
            int maxValueFromRation = -1;
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
            if (bestForEat != null) {
                setEnergy((int) (getEnergy() + bestForEat.getKey().getWeight()));
                System.out.println("Predator " + this + "is eating " + bestForEat.getValue().get(0));
                bestForEat.getValue().remove(0);
            }
        }
    }
}
