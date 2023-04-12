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
                map[i][j] = currentLocation;
            }
        }
    }

    public void iterate() throws InterruptedException {
        //Thread locationThread = new Thread(() -> {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                Location currentLocation = map[i][j];
                List<Animal> predators = new ArrayList<>();
                List<Animal> herbivores = new ArrayList<>();
                for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                    CopyOnWriteArrayList<Animal> animalList = entry.getValue();
                    Thread locationThread = new Thread(() -> {
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
                    });
                    locationThread.start();
                    locationThread.join();
                    //  System.out.println("Before moved" + currentLocation);
                }
            }
            //  });
        }
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
                        Location newLocation = map[newX][newY];
                        if (newLocation.isFree()) {
                            //System.out.println("old Location "+  animal.getType() + " "+  animal.getX() + " "+ animal.getX());
                            animal.moveTo(nextX, nextY, animal);
                            currentLocation.removeAnimal(animal);
                            newLocation.addAnimal(animal);
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
                                if (currentLocation.isFree()) {
                                    Animal newAnimal = currentLocation.addNewAnimal(animalType, firstAnimal.getX(), firstAnimal.getY());
                                    currentLocation.addAnimal(newAnimal);
                                   // System.out.println("new Animal " + animalType + " bred from " + secondAnimal.getType());
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
                "width=" + width +
                ", height=" + height +
                ", map=" + Arrays.toString(map) +
                '}';
    }
}


