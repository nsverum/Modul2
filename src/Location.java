
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


    public void grousePlant() {
        plantVolume = plantVolume+20;
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


   public void addAnimal(Map<Type, CopyOnWriteArrayList<Animal>> animalMap) {
        for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : animalMap.entrySet()) {
            Animal newAnimal = switch (entry.getKey()) {
                case WOLF -> new Wolf(getX(), getY(), numAnimals, 50, true, "?");
                case SHEEP -> new Sheep(getX(), getY(), numAnimals, 50, true, "?");
                case HORSE -> new Horse(getX(), getY(), numAnimals, 50, true, "?");
                case BEAR -> new Bear(getX(), getY(), numAnimals, 50, true, "?");
                case FOX -> new Fox(getX(), getY(), numAnimals, 50, true, "?");
            };
            if (entry.getValue() != null) {
                entry.getValue().add(newAnimal);
            }
        }
    }
    public boolean isFree() {
        return true;
    }

    public void removeAnimal(ConcurrentHashMap<Type, CopyOnWriteArrayList<Animal>> animal) {
        for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : animal.entrySet()) {
            List<Animal> animalList = entry.getValue();
            for (Animal previousLocationAnimal : animalList) {
                animalList.remove(previousLocationAnimal);
            }
        }

    }
}
