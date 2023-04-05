
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


   public void addAnimal(Map<Type, CopyOnWriteArrayList<Animal>> animalMap) {
        for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : animalMap.entrySet()) {
            List<Animal> animalList = entry.getValue();
            Animal newAnimal = switch (entry.getKey()) {
                case WOLF -> new Wolf(getX(), getY(), numAnimals, 50, true, "?", Type.WOLF);
                case SHEEP -> new Sheep(getX(), getY(), numAnimals, 50, true, "?", Type.SHEEP);
                case HORSE -> new Horse(getX(), getY(), numAnimals, 50, true, "?", Type.HORSE);
                case BEAR -> new Bear(getX(), getY(), numAnimals, 50, true, "?",Type.SHEEP);
                case FOX -> new Fox(getX(), getY(), numAnimals, 50, true, "?",Type.FOX);
                case MOUSE -> new Mouse(getX(), getY(), numAnimals, 50, true, "?",Type.MOUSE);
                case RABBIT -> new Rabbit(getX(), getY(), numAnimals, 50, true, "?",Type.RABBIT);

            };
            if (animalList != null){
                entry.getValue().add(newAnimal);
            }
        }
    }
    public boolean isFree(Map<Type, CopyOnWriteArrayList<Animal>> animalMap) {
        for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : animalMap.entrySet()) {
            Type animalType = entry.getKey();
            List<Animal> animalList = entry.getValue();

            return animalList.size() <= animalType.getMaxPerCell();
        }
        return false;
    }

}
