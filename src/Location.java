
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
            Animal newAnimal = switch (entry.getKey()) { // Створюємо новий об'єкт-тварину відповідно до типу, який вже визначений
                case WOLF -> new Wolf();
                case SHEEP -> new Sheep();
                case HORSE -> new Horse();
                case BEAR -> new Bear();
                case FOX -> new Fox();
            };
            if (entry.getValue() != null) {
                entry.getValue().add(newAnimal);
                System.out.println("Тварина добавлена");
            }
        }
    }
    public  void remove(){

    }
    public void die(Map<Type, List<Animal>> animalMap) {
        for (Map.Entry<Type, List<Animal>> entry : animalMap.entrySet()) {
            Animal newAnimal = switch (entry.getKey()) { // Створюємо новий об'єкт-тварину відповідно до типу, який вже визначений
                case WOLF -> new Wolf();
                case SHEEP -> new Sheep();
                case HORSE -> new Horse();
                case BEAR -> new Bear();
                case FOX -> new Fox();
            };
            if (entry.getValue() != null) {
                entry.getValue().remove(newAnimal);
                System.out.println("Тварина померла");
            }
        }
    }

    public void checkIsAlive(Type type) {

    }

    public boolean isFree() {
        return true;
    }
}
