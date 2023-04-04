import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
public abstract class Animal {
    private int x;
    private int y;
    private  Type type;
    private int number;
    private int energy;
    private boolean isAlive;
    private String gender;

    public Animal(int x, int y, int number, int energy, boolean isAlive, String gender, Type type) {
        this.x = x;
        this.y = y;
        this.number = number;
        this.energy = energy;
        this.isAlive = isAlive;
        this.gender = gender;
        this.type= type;
    }
    public static void eat(CopyOnWriteArrayList<Animal> allAnimals, Animal animal) {
        List<Animal> predators = new ArrayList<>();
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
            int maxChance = Collections.max(predator.getType().getRation().values());
            Type typeWithMaxFoodValue = null;
            for (Type key : predator.getType().getRation().keySet()) {

                if (predator.getType().getRation().get(key) == maxChance) {
                    typeWithMaxFoodValue = key;
                    break;
                }
            }   if (predator.isHungry(predator)) {
                Animal herbivoreToEat = null;
                int maxFoodValue = -1;
                for (Animal herbivore : herbivores) {
                    int foodValue = herbivore.getType().getRation().get(typeWithMaxFoodValue);
                    if (foodValue >=  maxChance) {
                       herbivoreToEat = herbivore;
                    }
                }
                if (herbivoreToEat != null) {
                    herbivores.remove(herbivoreToEat);
                    allAnimals.remove(herbivoreToEat);
                }
                for (Animal herbivore : herbivores){
                    if (predator.isHungry(predator)) {
                        herbivore.eatPlants();
                    }
                }
            }
        }
    }

    private void eatPlants() {
        System.out.println("Animal eats");
    }

    boolean isHungry(Animal animal) {
        return animal.getEnergy() < animal.getType().getMaxEnergy();
    }
    public  void reproduce(Map<Type, List<Animal>> animals){
        for (Map.Entry<Type, List<Animal>> entry : animals.entrySet()) {
            List<Animal> animalList =  entry.getValue();
        }
    }
    public void moveTo(int newX, int newY, Animal animal) {
        this.x = newX;
        this.y = newY;
        this.energy--;
        if (this.energy <= 0) {
            this.isAlive = false;
        }
        System.out.println(animal);
        System.out.println(getX() +" "+ getY());
    }
    public  void canDie(Animal animal){
        if (animal.getClass().isAnnotationPresent(Predators.class)) {
            System.out.println("Помер від голоду");
        } else if (animal.getClass().isAnnotationPresent(Herbivore.class)) {
            System.out.println("Помер від голоду або його з'їли");
        }
    }
    public Type getType() {
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

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Animal{" + getClass().toString() +
                ": x=" + x +
                ", y=" + y +
                '}';
    }
}
