
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Setter
@Getter
public class Location {
    private int x;
    private int y;

    int plantVolume;
    int numAnimals;
    ConcurrentHashMap<Type, CopyOnWriteArrayList<Animal>> animalMap;

    public Location() {
      FillStartDataForLocation.fillStartDataForLocation(this);
    }

    @Override
   public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("Location{");
       sb.append("Кількість рослин =").append(plantVolume).append(", ");
       sb.append("У цій локації такі тварини = {");
       for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : animalMap.entrySet()) {
           sb.append(entry.getKey()).append(": ").append(entry.getValue().size()).append(", ");
       }
       sb.delete(sb.length() - 2, sb.length());
       sb.append("}}");
       return sb.toString();
   }


   public Animal addNewAnimal(Type type, int x, int y) {
            Animal newAnimal = switch (type) {
                case WOLF -> new Wolf(x, y, numAnimals, 50, true,  Type.WOLF);
                case SHEEP -> new Sheep(x, y, numAnimals, 50, true,  Type.SHEEP);
                case HORSE -> new Horse(x, y, numAnimals, 50, true, Type.HORSE);
                case BEAR -> new Bear(x, y, numAnimals, 50, true, Type.SHEEP);
                case FOX -> new Fox(x, y, numAnimals, 50, true, Type.FOX);
                case MOUSE -> new Mouse(x, y, numAnimals, 50, true, Type.MOUSE);
                case RABBIT -> new Rabbit(x, y, numAnimals, 50, true, Type.RABBIT);
            };
            return newAnimal;
   }
    public boolean isFree(Location location, Animal animal) {

            return location.getAnimalMap().values().size() <= animal.getType().getMaxPerCell();


    }

    public void removeAnimal(Animal animal) {
        animalMap.get(animal.getType()).remove(animal);
    }

    public void addAnimal(Location location, Animal animal) {
        for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : animalMap.entrySet()) {
            List<Animal> animalList = entry.getValue();
            animalList.add(animal);
        }
        //animalMap.computeIfAbsent(animal.getType(), k -> new CopyOnWriteArrayList<>()).add(animal);
    }
}
