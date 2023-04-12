import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class FillStartDataForLocation {
    public static void fillStartDataForLocation(Location location) {
        Random random = new Random();
        location.setPlantVolume(random.nextInt(2000));
        location.setX(random.nextInt(99));
        location.setY(random.nextInt(19));
        ConcurrentHashMap<Type, CopyOnWriteArrayList<Animal>> animalMap = new ConcurrentHashMap<>();

        for (int i = 0; i < 10; i++) {
            Type type = Type.values()[ThreadLocalRandom.current().nextInt(0, 7)];
            CopyOnWriteArrayList<Animal> animalList = new CopyOnWriteArrayList<>();
            int numAnimals = random.nextInt(type.getMaxPerCell());
            for (int j = 0; j < numAnimals; j++) {
                Animal newAnimal = switch (type) {
                    case WOLF -> new Wolf(location.getX(), location.getY(), numAnimals, 1, true, Type.WOLF);
                    case SHEEP -> new Sheep(location.getX(), location.getY(), numAnimals, 1, true, Type.SHEEP);
                    case HORSE -> new Horse(location.getX(), location.getY(), numAnimals, 1, true,  Type.HORSE);
                    case BEAR -> new Bear(location.getX(), location.getY(), numAnimals, 20, true, Type.BEAR);
                    case FOX -> new Fox(location.getX(), location.getY(), numAnimals, 1, true, Type.FOX);
                    case MOUSE -> new Mouse(location.getX(), location.getY(), numAnimals, 1, true, Type.MOUSE);
                    case RABBIT -> new Rabbit(location.getX(), location.getY(), numAnimals, 1, true, Type.RABBIT);

                };

                animalList.add(newAnimal);
            }

            animalMap.put(type, animalList);
            location.setAnimalMap(animalMap);

        }
    }

}
