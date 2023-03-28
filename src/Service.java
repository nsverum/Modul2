import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Service {

    private final Location[][] map;

    public Service(int width, int height) {
        this.map = new Location[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Location currentLocation = new Location();
                currentLocation.setX(i);                   // Координати локації
                currentLocation.setY(j);
                map[i][j] = new Location();

                }
        }
       /* for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++)
                System.out.println(map[i][j]);
            System.out.println();
        }*/
    }
    public  void iterate() throws InterruptedException {     // крок 1
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                Location currentLocation = map[i][j];
                for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                    Type animalType = entry.getKey();
                    List<Animal> animalList = entry.getValue();
                    Thread locationThread = new Thread(() -> {
                        //  логіка для кожної локації

                        int x = currentLocation.getX();
                        int y = currentLocation.getY();


                        for (Animal animal : animalList) {
                            animal.canEat(animal);
                            animal.canDie();
                        }

                    });
                    locationThread.start();
                    locationThread.join();
                }
            }
        }
    }
        //  отримуємо траекторію руху                             // крок 2

    public void moveAnimals () {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 20; j++) {
                    Location currentLocation = map[i][j];
                    for (Map.Entry<Type, CopyOnWriteArrayList<Animal>> entry : currentLocation.animalMap.entrySet()) {
                        Type animalType = entry.getKey();
                        List<Animal> animalList = entry.getValue();
                        for (Animal animal : animalList) {
                            // Визначаємо максимальну кількість клітинок, які тварина може пройти за раз
                            int maxCells = animalType.getSpeed();

                            // Визначаємо нову позицію тварини
                            int newX = animal.getX() + (int) (Math.random() * (maxCells * 2 + 1)) - maxCells;
                            int newY = animal.getY() + (int) (Math.random() * (maxCells * 2 + 1)) - maxCells;

                            // Перевіряємо, щоб нова позиція тварини була в межах мапи
                            if (newX < 0) newX = 0;
                            if (newY < 0) newY = 0;
                            if (newX >= 100) newX = 100 - 1;
                            if (newY >= 20) newY = 20 - 1;


                            // Перевіряємо, чи вільна нова локація
                            Location newLocation = map[newX][newY];
                            if (newLocation.isFree()) {
                                // Вільна, переміщуємо тварину
                                animal.moveTo(newX, newY);
                                newLocation.addAnimal(currentLocation.animalMap);
                                currentLocation.remove();

                            }
                            System.out.print(newX + " ");
                            System.out.print(newY);

                            /*else {
                                // Не вільна, перевіряємо можливість атаки або уникнення
                                Animal otherAnimal = (Animal) newLocation.getAnimalMap();
                                if (otherAnimal.getType() == animalType) {
                                    // Тварини одного типу, можно ро
                                } else if (animal.canAttack(otherAnimal)) {
                                    // Можливість атаки, атакуємо
                                    animal.attack(otherAnimal);
                                } else {
                                    // Не можливість атаки та уникнення, тварини зіткнулись
                                }
                            }*/
                        }
                    }
                }
            }
        }



}


