
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
                case WOLF -> new Wolf(50, true,  Type.WOLF);
                case SHEEP -> new Sheep( 50, true,  Type.SHEEP);
                case HORSE -> new Horse(50, true, Type.HORSE);
                case BEAR -> new Bear( 50, true, Type.SHEEP);
                case FOX -> new Fox(50, true, Type.FOX);
                case MOUSE -> new Mouse(50, true, Type.MOUSE);
                case RABBIT -> new Rabbit(50, true, Type.RABBIT);
            };
            return newAnimal;
   }
    public boolean isFree(Location location, Animal animal) {
        for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : location.getAnimalMap().entrySet()) {
            List<Animal> animalList = entry.getValue();
            return animalList.size() <= animal.getType().getMaxPerCell();
        }
        return false;
    }

    public void removeAnimal(List<Animal> animalList, Animal animal) {
        animalList.remove(animal);
    }

    public void addAnimal(Location location, Animal animal) {
        for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : location.getAnimalMap().entrySet()) {
            List<Animal> animalList = entry.getValue();
            animalList.add(animal);
        }
        //animalMap.computeIfAbsent(animal.getType(), k -> new CopyOnWriteArrayList<>()).add(animal);
    }
}
