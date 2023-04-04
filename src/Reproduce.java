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
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                Location currentLocation = new Location();
            }
                for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                    Type animalType = entry.getKey();
                    List<Animal> animalList = entry.getValue();
                    for (Animal animal : animalList) {

                    }

        if (!parent1.canBreedWith(parent2)) {
            System.out.println("Ці тварини не можуть розмножуватися.");
            return null;
        }

        // створюємо нову тварину на основі батьків
        String name = parent1.getName() + "-" + parent2.getName();
        String species = parent1.getSpecies();
        int age = 0;
        double weight = parent1.getWeight() * 0.5 + parent2.getWeight() * 0.5;
        String gender = Math.random() < 0.5 ? parent1.getGender() : parent2.getGender();

        Animal baby = new Animal(int x, int y, int number, int energy, boolean isAlive, String gender, Type type);
        System.out.println("Нова тварина народилася: " + baby.getName());

        // повертаємо нову тварину
        return baby;

    }

    @Override
    public Animal call() throws Exception {
        return null;
    }
}
