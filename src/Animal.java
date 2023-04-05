import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
public abstract class Animal {
    private int x;
    private int y;
    private Type type;
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
        this.type = type;
    }

    public void eatPredators(List<Animal> herbivores, Animal predator) {
      /* Type bestTypeForEat = predator.getType().getRation().entrySet().stream().min(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .stream().findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);*/
        if (predator.isHungry(predator)) {
            int maxValueFromRation = 1;
            Iterator<Animal> iterator = herbivores.iterator();
            while (iterator.hasNext()) {
                Animal herbivore = iterator.next();
                int bestTypeForEat = predator.getType().getRation().get(herbivore.getType());
                if(bestTypeForEat > maxValueFromRation){
                    maxValueFromRation = bestTypeForEat;
                    iterator.remove();
                    System.out.println(herbivore.getType() + " was eaten" +  " by " + predator.getType());
                  //  predator.setEnergy((int) (predator.getEnergy() + herbivoreToEat.getType().getWeight()));
                }
            }
        }
    }

    public void eatHerbivores(List<Animal> herbivores, Animal herbivore) {
        if (herbivore.isHungry(herbivore)) {
            herbivore.setEnergy(herbivore.getEnergy()*2);
            if (herbivore.getEnergy() < 0) {
                herbivores.remove(herbivore);
            }
            System.out.println("HerbivoreAnimal " + herbivore.getType() + " eats grass");
        }
    }

    boolean isHungry(Animal animal) {
        return animal.getEnergy() < animal.getType().getMaxEnergy();
    }

    public void reproduce(Map<Type, List<Animal>> animals) {
        for (Map.Entry<Type, List<Animal>> entry : animals.entrySet()) {
            List<Animal> animalList = entry.getValue();
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
        System.out.println(getX() + " " + getY());
    }

    public void canDie(Animal animal) {
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
