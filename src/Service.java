import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Service {
    private final Location[][] map;
    public Service(int width, int height) {
        this.map = new Location[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Location currentLocation = new Location();
                currentLocation.setX(i);
                currentLocation.setY(j);
                map[i][j] = currentLocation;

            }
        }
    }


    public  void iterate() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                Location currentLocation = map[i][j];
                for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                    CopyOnWriteArrayList<Animal> animalList = entry.getValue();
                    Thread locationThread = new Thread(() -> {
                        for (Animal animal : animalList) {
                            animal.eat(animalList, animal);
                            animal.
                        }
                    });
                    locationThread.start();
                    locationThread.join();
                }
            }
        }
    }

    public void moveAnimals () {
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

                 Location newLocation = map[newX][newY];

                            if (newLocation.isFree()) {
                                animal.moveTo(newX, newY);
                                newLocation.addAnimal(currentLocation.animalMap);
                            }
                        }
                    }
                }
            }
        }
    public  void reproduce() throws InterruptedException {
        Location currentLocation = new Location();
        Thread locationThread = new Thread(() -> {

            reproduce();///////
        }
            for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                CopyOnWriteArrayList<Animal> animalList = entry.getValue();
                for (Animal animal : animalList) {
                    for (Animal animal : animalList) {
                        if (animal.getType() == animalType) {
                            animalsOfType.add(animal);
                        }
                    }


            });
            locationThread.start();
            locationThread.join();
        }
    }
    public Location[][] getMap() {
        return map;
    }

}


