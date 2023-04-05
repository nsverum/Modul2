import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Service {
    int width;
    int height;
    private final Location[][] map;

    public Service(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new Location[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Location currentLocation = new Location();
                map[i][j] = currentLocation;
            }
        }
    }

    public void iterate() throws InterruptedException {
        Thread locationThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 20; j++) {
                    Location currentLocation = map[i][j];

                    List<Animal> predators = new ArrayList<>();
                    List<Animal> herbivores = new ArrayList<>();

                    for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                        CopyOnWriteArrayList<Animal> animalList = entry.getValue();

                        for (Animal animal : animalList) {
                            if (animal.getClass().isAnnotationPresent(Predators.class)) {
                                predators.add(animal);
                            } else if (animal.getClass().isAnnotationPresent(Herbivore.class)) {
                                herbivores.add(animal);
                            }
                        }
                        for (Animal predator : predators) {
                            predator.eatPredators(herbivores, predator);
                        }
                        for (Animal herbivore : herbivores) {
                            herbivore.eatHerbivores(herbivores, herbivore);
                        }
                        animalList.clear();
                        animalList.addAll(predators);
                        animalList.addAll(herbivores);
                    }
                }
            }

        });
        locationThread.start();
        locationThread.join();

    }

    public void moveAnimals() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                Location currentLocation = map[i][j];
                for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                    Type animalType = entry.getKey();
                    List<Animal> animalList = entry.getValue();
                    for (Animal animal : animalList) {
                        int maxCells = animalType.getSpeed();
                        int newX = animal.getX() + (int) (Math.random() * (maxCells * 2 + 1)) - maxCells;
                        int newY = animal.getY() + (int) (Math.random() * (maxCells * 2 + 1)) - maxCells;
                        if (newX < 0) newX = 0;
                        if (newY < 0) newY = 0;
                        if (newX >= 100) newX = 100 - 1;
                        if (newY >= 20) newY = 20 - 1;
                        int nextX = newX;
                        int nextY = newY;

                        Location newLocation = map[nextX][nextY];
                        newLocation.setX(nextX);
                        newLocation.setY(nextY);
                        if (newLocation.isFree(newLocation.getAnimalMap())) {
                            animal.moveTo(nextX, nextY, animal);
                            animalList.remove(animal);
                            newLocation.addAnimal(newLocation.animalMap);
                            System.out.println(currentLocation);
                            System.out.println(newLocation);
                        }
                    }
                }
            }
        }
    }

    public void multiplyAnimals() {

    }

    @Override
    public String toString() {
        return "Service{" +
                "width=" + width +
                ", height=" + height +
                ", map=" + Arrays.toString(map) +
                '}';
    }
}


