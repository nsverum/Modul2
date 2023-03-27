
import java.util.*;

public class Location {
    int plantVolume;
    int numAnimals;
    Map<Type, List<Animal>> animalMap;

    public Location() {

      FillStartDataForLocation.fillStartDataForLocation(this);
    }


    public void grousePlant() {
        plantVolume = plantVolume+20;
    }

    public int getPlantVolume() {
        return plantVolume;
    }

    public void setPlantVolume(int plantVolume) {
        this.plantVolume = plantVolume;
    }

    public Map<Type, List<Animal>> getAnimalMap() {
        return animalMap;
    }

    public void setAnimalMap(Map<Type, List<Animal>> animalMap) {
        this.animalMap = animalMap;
    }

    public int getNumAnimals() {
        return numAnimals;
    }

    public void setNumAnimals(int numAnimals) {
        this.numAnimals = numAnimals;
    }

    @Override
   public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("Location{");
       sb.append("Кількість рослин =").append(plantVolume).append(", ");
       sb.append("У цій локації такі тварини = {");
       for (Map.Entry<Type, List<Animal>> entry : animalMap.entrySet()) {
           sb.append(entry.getKey()).append(": ").append(entry.getValue().size()).append(", ");
       }
       sb.delete(sb.length() - 2, sb.length());
       sb.append("}}");
       return sb.toString();
   }
    public void addAnimal(Type type, Animal animal) {
        List<Animal> animalList = animalMap.get(type);
        if (animalList != null) {
            animalList.add(animal);
            System.out.println("Тварина добавлена");
        }
    }
    public void addAnimal(Map<Type, List<Animal>> animalMap) {
        for (Map.Entry<Type, List<Animal>> entry : animalMap.entrySet()) {
            Animal newAnimal = switch (entry.getKey()) { // Створюємо новий об'єкт-тварину відповідно до типу, який вже визначений
                case WOLF -> new Wolf();
                case SHEEP -> new Sheep();
                case HORSE -> new Horse();
                case BEAR -> new Bear();
                case FOX -> new Fox();
            };

            entry.getValue().add(newAnimal);
            System.out.println(newAnimal);
        }

    }
}
