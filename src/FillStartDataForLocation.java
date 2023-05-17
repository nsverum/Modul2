import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class FillStartDataForLocation {
    public static void fillStartDataForLocation(Location location) {
        Random random = new Random();
        location.setPlantVolume(random.nextInt(200));
        ConcurrentHashMap<Type, CopyOnWriteArrayList<Animal>> animalMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            Type type = Type.values()[ThreadLocalRandom.current().nextInt(0, 7)];
            CopyOnWriteArrayList<Animal> animalList = new CopyOnWriteArrayList<>();
            int numAnimals = random.nextInt(type.getMaxPerCell());
            for (int j = 0; j < numAnimals; j++) {
                Animal newAnimal = switch (type) {
                    case WOLF -> new Wolf(1, true, Type.WOLF);
                    case SHEEP -> new Sheep( 1, true, Type.SHEEP);
                    case HORSE -> new Horse( 1, true,  Type.HORSE);
                    case BEAR -> new Bear(20, true, Type.BEAR);
                    case FOX -> new Fox( 1, true, Type.FOX);
                    case MOUSE -> new Mouse( 1, true, Type.MOUSE);
                    case RABBIT -> new Rabbit( 1, true, Type.RABBIT);

                };

                animalList.add(newAnimal);
            }

            animalMap.put(type, animalList);
            location.setAnimalMap(animalMap);

        }
    }

}
