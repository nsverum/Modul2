import java.lang.reflect.Type;
import java.util.*;

public class Location {
    int plantVolume;
    int animalNumber;
    Map<Type, List<Animal>> animal;
    public Location(int plantVolume, Map<Type, List<Animal>> animal) {
        this.plantVolume = plantVolume;
        this.animal = animal;
    }
    public void addAnimal(List<Animal> animalLis) {

    }
    public void grousePlant() {
        plantVolume = plantVolume+20;
    }
    private void populateAnimals() {
        Random rand = new Random();
        int numAnimals = rand.nextInt(10) + 1;
        // рандомна кількість тварин
        Map<Type, List<Animal>> animalMap = new HashMap<>();
        animalMap.put(Type.WOLF, new ArrayList<>());
        animalMap.put(Type.BEAR, new ArrayList<>());
        Location location = new Location(numAnimals, animalMap);
        List<Animal> herbivores = animalMap.get(Type.WOLF);
    }

}
