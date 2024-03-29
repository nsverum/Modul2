
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

    private int plantVolume;
    private int numAnimalsToDie;
    private int numAnimalsToBreed;

    ConcurrentHashMap<Type, CopyOnWriteArrayList<Animal>> animalMap;

    public Location() {
      FillStartDataForLocation.fillStartDataForLocation(this);
    }

    @Override
   public String toString() {
       StringBuilder sb = new StringBuilder();
        sb.append("____________________________________________________ " + "\n");

        sb.append("Location with coordinates: "+ getX() + " " + getY() + "\n");
       sb.append("Кількість рослин = ").append(plantVolume).append(", ");
       sb.append("У цій локації такі тварини = ");

        for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : animalMap.entrySet()) {
           sb.append(entry.getKey()).append(": ").append(entry.getValue().size()).append("; ");
       }
        sb.append("\n" + "Померло:  " + numAnimalsToDie);
        sb.append("\n" + "Народилося:  " + numAnimalsToBreed);

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
                case SNAKE -> new Snake(50, true, Type.SNAKE);
                case EAGLE -> new Eagle(50, true, Type.EAGLE);
                case DEER -> new Deer(50, true, Type.DEER);
                case GOAT -> new Goat(50, true, Type.GOAT);
                case BOAR -> new Buffalo(50, true, Type.BUFFALO);
                case BUFFALO -> new Buffalo(50, true, Type.BUFFALO);
                case DUCK -> new Duck(50, true, Type.DUCK);
                case CATERPILLAR -> new Caterpillar(50, true, Type.CATERPILLAR);

            };
            return newAnimal;
   }
    public boolean isFree(Animal animal) {
        return getAnimalMap().get(animal.getType()) == null
            || getAnimalMap().get(animal.getType()).size() < animal.getType().getMaxPerCell();
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
