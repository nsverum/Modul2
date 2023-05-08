import java.util.*;
import java.util.concurrent.*;
import java.util.function.BiConsumer;

public class Service {
    int width;
    int height;
    private final Location[][] map;
    private final ExecutorService executorService;

    public Service(int width, int height, int numThreads) {
        this.width = width;
        this.height = height;
        executorService = Executors.newFixedThreadPool(numThreads);
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
    public void executeAction(BiConsumer<List<Animal>,Location> action) throws ExecutionException, InterruptedException {
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Location currentLocation = map[i][j];
                Future<?> future = executorService.submit(() -> {
                    for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                        CopyOnWriteArrayList<Animal> animalList = entry.getValue();
                            action.accept(animalList, currentLocation);
                    }
                });
                futures.add(future);
            }
        }
        for (Future<?> future : futures){
            future.get();
        }

    }

    public void eating() throws ExecutionException, InterruptedException {
        executeAction((animalList,currentLocation) -> {
            for (Animal animal : animalList) {
                //animal.eat(currentLocation.animalMap);
                animal.eat(currentLocation);
                Random random =  new Random();
                currentLocation.setPlantVolume(currentLocation.getPlantVolume() + random.nextInt(10));
            }
        });
    }

    public void choseDestination() throws ExecutionException, InterruptedException {
        executeAction((animalList,currentLocation) -> {
            for (Animal animal : animalList) {
                int maxCells = animal.getType().getSpeed();
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
        });
    }
    public void moveAnimals() throws ExecutionException, InterruptedException {
       executeAction((animalList, currentLocation) ->{
           for (Animal animal : animalList) {
//               System.out.println(animal + " will be moved from " + animal.getCurrentLocation().getX() +  " " + animal.getCurrentLocation().getY() +
//                       " to " + animal.getNewLocation().getX() +  " " +  animal.getNewLocation().getY());
               animal.move();

           }
       });
    }

    public void breedAnimals() throws InterruptedException, ExecutionException {
        executeAction((animalList, currentLocation) ->{
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
                                //    System.out.println("new Animal " + animalType + " bred from " + secondAnimal.getType());
                                }
                            }
                        }
        });
    }
    public void close() {
        executorService.shutdown();
    }

    @Override
    public String toString() {
        return getMap().toString();
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


