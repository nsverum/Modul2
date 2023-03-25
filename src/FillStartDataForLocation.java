import java.util.*;

public class FillStartDataForLocation {
    public static void fillStartDataForLocation(Location location) {

        // animalMap.put(Type.WOLF, new ArrayList<>());
       // animalMap.put(Type.BEAR, new ArrayList<>());
       // animalMap.put(Type.FOX, new ArrayList<>());
       // animalMap.put(Type.HORSE, new ArrayList<>());
       // animalMap.put(Type.SHEEP, new ArrayList<>());

// Генерируем случайное количество животных случайного типа и добавляем их в Map
        Random random = new Random();
        location.setPlantVolume(random.nextInt(11));

        Map<Type, List<Animal>> animalMap;
        animalMap = location.getAnimalMap();
        List<Animal> animalList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Type type = Type.values()[random.nextInt(Type.values().length)]; // выбираем случайный тип из enum Type
            int numAnimals = random.nextInt(type.getMaxPerCell());
            for (int j = 0; j < numAnimals; j++) {
                // animalList = animalMap.get(type);
                animalMap.get(type).add((Animal) Animal.getType()); // создаем новое животное и добавляем его в соответствующий список в Map
            }

            animalMap.put(type, new ArrayList<>());

        }
    }




}
