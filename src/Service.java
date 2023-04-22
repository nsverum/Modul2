import java.util.*;
import java.util.concurrent.*;

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
                currentLocation.setX(i);
                currentLocation.setY(j);
                map[i][j] = currentLocation;
                for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                    CopyOnWriteArrayList<Animal> animalList = entry.getValue();
                    for (Animal animal : animalList) {
                        animal.setCurrentLocation(currentLocation);
                    }
                }
            }
        }
    }
    public void eating() throws InterruptedException {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Location currentLocation = map[i][j];
                for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                    CopyOnWriteArrayList<Animal> animalList = entry.getValue();
                        for (Animal animal : animalList) {
                            animal.eat(currentLocation.animalMap);
                        }
                }
            }
        }
    }

    public void choseDestination() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Location currentLocation = map[i][j];
                for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                    Type animalType = entry.getKey();
                    List<Animal> animalList = entry.getValue();
                    for (Animal animal : animalList) {
                        int maxCells = animalType.getSpeed();
                        int newX = animal.getCurrentLocation().getX() + (int) (Math.random() * (maxCells * 2 + 1)) - maxCells;
                        int newY = animal.getCurrentLocation().getY() + (int) (Math.random() * (maxCells * 2 + 1)) - maxCells;
                        if (newX < 0) newX = 0;
                        if (newY < 0) newY = 0;
                        if (newX >= width) newX = width - 1;
                        if (newY >= height) newY = height - 1;
                        int nextX = newX;
                        int nextY = newY;
                        Location newLocation = map[nextX][nextY];
                        animal.setNewLocation(newLocation);
                    }
                }
            }
        }
    }
    public void moveAnimals(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Location currentLocation = map[i][j];
                for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                    Type animalType = entry.getKey();
                    List<Animal> animalList = entry.getValue();
                    for (Animal animal : animalList) {
                        System.out.println(animal + " will be moved from " + animal.getCurrentLocation().getX() +  " " + animal.getCurrentLocation().getY() +
                                " to " + animal.getNewLocation().getX() +  " " +  animal.getNewLocation().getY());
                        animal.move();
                    }
                }
            }
        }
    }

    public void breedAnimals() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Location currentLocation = map[i][j];
                for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                    CopyOnWriteArrayList<Animal> animalList = entry.getValue();
                    Future<?> future = executorService.submit(() -> {
                        for (int k = 0; k < animalList.size(); k += 2) {
                            Animal firstAnimal = animalList.get(k);
                            Animal secondAnimal = k + 1 < animalList.size() ? animalList.get(k + 1) : null;
                            if (((firstAnimal != null) && (secondAnimal != null)
                                    && (firstAnimal.getGender() != secondAnimal.getGender()))) {
                                Type animalType = firstAnimal.getType();
                                if (currentLocation.isFree(firstAnimal)) {
                                    Animal newAnimal = currentLocation.addNewAnimal(animalType);
                                    currentLocation.addAnimal(newAnimal);
                                    newAnimal.setCurrentLocation(currentLocation);
                                    System.out.println("new Animal " + animalType + " bred from " + secondAnimal.getType());
                                }
                            }
                        }
                    });
                    futures.add(future);
                }
            }
        }
        for (Future<?> future : futures) {
            future.get();
        }
        executorService.shutdown();

    }

    @Override
    public String toString() {
        return "Service{" +
                "map=" + Arrays.toString(map) +
                '}';
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Location[][] getMap() {
        return map;
    }
}


