import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public abstract class Animal {
    private int x;
    private int y;
    private static Type type;
    private int number;
    private int energy = 50;

    private boolean isAlive;
    private String gender;
    List<Animal> animalList;


    public void eat(CopyOnWriteArrayList<Animal> allAnimals, Animal animal) {
        System.out.println(animal);

       /* List<Animal> predators = new ArrayList<>();
        List<Animal> herbivores = Collections.synchronizedList(new ArrayList<>());
        for (Animal otherAnimal : allAnimals){
            if (otherAnimal == animal){
                continue;
            }
            if (otherAnimal.getClass().isAnnotationPresent(Predators.class)) {
                predators.add(otherAnimal);
            } else if (otherAnimal.getClass().isAnnotationPresent(Herbivore.class)) {
                herbivores.add(otherAnimal);
            }
        }
        for (Animal predator : predators) {
            int maxChance = Collections.max(type.ration.values());
            Type typeWithMaxFoodValue = null;
            for (Type key : type.ration.keySet()) {
                if (type.ration.get(key) == maxChance) {
                    typeWithMaxFoodValue = key;
                    break;
                }
            }
            if (predator.isHungry()) {
                Animal herbivoreToEat = null;
                int maxFoodValue = -1;
                for (Animal herbivore : herbivores) {
                    int foodValue = herbivore.getType().getRation().get(typeWithMaxFoodValue);
                    if (foodValue > maxFoodValue) {
                        maxFoodValue = foodValue;
                        herbivoreToEat = herbivore;
                    }
                }
                if (herbivoreToEat != null) {
                    herbivores.remove(herbivoreToEat);
                    allAnimals.remove(herbivoreToEat);

                }
            }
        }*/
    }


    private boolean isHungry() {

        return true;
    }
    public  void reproduce(){
        List<Animal> animals = ... // список всіх тварин

// фільтруємо список тварин за їх типом
        Map<Type, List<Animal>> animalsByType = animals.stream()
                .collect(Collectors.groupingBy(Animal::getType));

// розбиваємо тварин по парам і запускаємо метод breed() для кожної пари
        List<Animal> pairedAnimals = new ArrayList<>();
        for (List<Animal> animalList : animalsByType.values()) {
            int size = animalList.size();
            for (int i = 0; i < size; i += 2) {
                Animal animal1 = animalList.get(i);
                Animal animal2 = (i + 1 < size) ? animalList.get(i + 1) : null;
                if (animal1 != null && animal2 != null) {
                    pairedAnimals.add(animal1);
                    pairedAnimals.add(animal2);
                    breed(animal1, animal2);
                }
            }
        }

// запускаємо метод breed() для тварин, що залишилися
        for (int i = 0; i < pairedAnimals.size(); i += 2) {
            Animal animal1 = pairedAnimals.get(i);
            Animal animal2 = pairedAnimals.get(i + 1);
            breed(animal1, animal2);
        }
    }
    public void moveTo(int newX, int newY) {
        this.x = newX;
        this.y = newY;
        this.energy--;
        if (this.energy <= 0) {
            this.isAlive = false;
        }
    }
    public  void canDie(Animal animal){
        if (animal.getClass().isAnnotationPresent(Predators.class)) {
            System.out.println("Помер від голоду");
        } else if (animal.getClass().isAnnotationPresent(Herbivore.class)) {
            System.out.println("Помер від голоду або його з'їли");
        }
    }
    public static Type getType() {
        return type;
    }
    public int getEnergy() {
        return energy;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public static void setType(Type type) {
        Animal.type = type;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "x=" + x +
                ", y=" + y +
                ", number=" + number +
                ", energy=" + energy +
                ", isAlive=" + isAlive +
                ", gender='" + gender + '\'' +
                ", animalList=" + animalList +
                '}';
    }
}
