import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Location {
    public Location(int plantVolume, Map<Type, List<Animal>> animal) {
        this.plantVolume = plantVolume;
        this.animal = animal;
    }

    int plantVolume;
    int animalNumber;
    Map<Type, List<Animal>> animal;


    public void addAnimal() {
        Animal animal = new Wolf();
        plantVolume++;
    }

    public void grousePlant() {
        Plant plant = new Plant();
        plantVolume++;
    }
    private static void populateAnimals() {
        Random rand = new Random();
        int numAnimals = rand.nextInt(10) + 1;
        // рандомна кількість тварин
        Map<Type, List<Animal>> animal;
    }

}
