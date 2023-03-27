import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class FillStartDataForLocation {
    public static void fillStartDataForLocation(Location location) {
        Random random = new Random();
        location.setPlantVolume(random.nextInt(11));
        Map<Type, List<Animal>> animalMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Type type = Type.values()[ThreadLocalRandom.current().nextInt(0, 4)]; //  випадковий тип з enum Type
            List<Animal> animalList = new ArrayList<>(); //Створюємо новий список для кожного типу тварин
            int numAnimals = random.nextInt(type.getMaxPerCell());
            for (int j = 0; j < numAnimals; j++) {
                Animal newAnimal = switch (type) { // Створюємо новий об'єкт-тварину відповідно до типу, який вже визначений
                    case WOLF -> new Wolf();
                    case SHEEP -> new Sheep();
                    case HORSE -> new Horse();
                    case BEAR -> new Bear();
                    case FOX -> new Fox();
                };

             // Додаємо новий об'єкт-тварину до списку для поточного типу тварин
                animalList.add(newAnimal);
            }

            // Додаємо список тварин до animalMap, використовуючи тип тварин, який вже визначений
            animalMap.put(type, animalList);
            location.setAnimalMap(animalMap);

        }
    }

}
