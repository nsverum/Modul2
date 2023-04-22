
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


   public Animal addNewAnimal(Type type) {
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
    public boolean isFree(Animal animal) {
        return getAnimalMap().get(animal.getType()) == null
            || getAnimalMap().get(animal.getType()).size() <= animal.getType().getMaxPerCell();
    }

    public void removeAnimal(Animal animal) {
       var animals = getAnimalMap().get(animal.getType());
       if (animals != null)
           animals.remove(animal);

    }

    public void addAnimal(Animal animal) {
        CopyOnWriteArrayList<Animal> animalList = getAnimalMap().get(animal.getType());
        if (animalList == null) {
            animalList = new CopyOnWriteArrayList<>();
            getAnimalMap().put(animal.getType(), animalList);
        }
        animalList.add(animal);
    }
}
