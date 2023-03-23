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
    Map<Type, List<Animal>> animal;
    private List<Animal> animals;

    public void addAnimal(Type type, List <Animal> list){
        animal.put(type, list );
    }
    public void grousePlant(){
        Plant plant = new Plant();
        plantVolume++;
    }
    private void populateAnimals() {
        Random rand = new Random();
        int numAnimals = rand.nextInt(10) + 1; // рандомна кількість тварин
        for (int i = 0; i < numAnimals; i++) {
            String name = "Animal " + i;
            Animal.Type type = Animal.Type.values()[rand.nextInt(Animal.Type.values().length)];
            Animal animal = new Animal(name, type);
            animals.add(animal);
        }
    }

    public int getPlantVolume() {
        return plantVolume;
    }

    public void setPlantVolume(int plantVolume) {
        this.plantVolume = plantVolume;
    }

    public Map<Type, List<Animal>> getAnimal() {
        return animal;
    }

    public void setAnimal(Map<Type, List<Animal>> animal) {
        this.animal = animal;
    }
}
