
import java.util.*;

public class Location {
    int plantVolume;
    Map<Type, List<Animal>> animalMap;
    public Location() {

      FillStartDataForLocation.fillStartDataForLocation(this);
    }
    public void addAnimal(List<Animal> animalLis) {

    }
    public void grousePlant() {
        plantVolume = plantVolume+20;
    }
    private void populateAnimals() {

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
}
