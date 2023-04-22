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
                       animal.setX(i);
                       animal.setY(j);
                    }
                }
            }
        }
    }
    public void eating() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                Location currentLocation = map[i][j];
                for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                    CopyOnWriteArrayList<Animal> animalList = entry.getValue();
                        for (Animal animal : animalList) {
                            animal.eat(currentLocation.animalMap);
                        }
                }
            }
        }
        System.out.println(map[0][0]);
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
                        if (newLocation.isFree(newLocation, animal)) {
                            animal.moveTo(nextX, nextY, animal);
                            currentLocation.removeAnimal(animalList);
                            newLocation.addAnimal(newLocation, animal);
                            System.out.println(animal + " was moved from " + currentLocation.getX() + currentLocation.getY() + " to " + newLocation.getX() + currentLocation.getY());
                        }
                    }
                }
            }
        }
    }

    public void breedAnimals() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
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
                                if (currentLocation.isFree(currentLocation, firstAnimal)) {
                                    Animal newAnimal = currentLocation.addNewAnimal(animalType, firstAnimal.getX(), firstAnimal.getY());
                                    currentLocation.addAnimal(currentLocation, newAnimal);
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


