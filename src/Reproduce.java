import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Reproduce implements Callable<Animal> {
    private final ConcurrentHashMap<Type, CopyOnWriteArrayList<Animal>> animalMap;

    public Reproduce(ConcurrentHashMap<Type, CopyOnWriteArrayList<Animal>> animalMap) {
        this.animalMap = animalMap;
    }


    @Override
    public Animal call() throws Exception {
        Location location = new Location();
        for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : location.animalMap.entrySet()) {
            Type animalType = entry.getKey();
            List<Animal> animalList = entry.getValue();
            for (Animal animal : animalList) {
            }
            Animal parent1 = null;
            Animal parent2 = null;
            if (animalList.size() >= 2) {
                parent1 = animalList.get(0);
                parent2 = animalList.get(1);
                if (parent1 == null || parent2 == null) {
                    System.out.println("Недостатня кількість тварин для розмноження.");
                    return null;
                }
          //  return breed(parent1, parent2);


            }

        }


        return null;
    }


}
