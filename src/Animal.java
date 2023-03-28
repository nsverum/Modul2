import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public abstract class Animal {
    private int x;
    private int y;
    private static Type type;
    private int number;
    private int energy = 50;

    private boolean isAlive;
    private String gender; // стать
    List<Animal> animalList;

    public void canEat(Animal animal) {
        if (animal.getClass().isAnnotationPresent(Predators.class)) {
            System.out.println("З'їли травоядну тварину");// харчування для хижака

           } else if (animal.getClass().isAnnotationPresent(Herbivore.class)) {
            System.out.println("З'їли траву");// харчування для травоїдної тварини
        } else {
            System.out.println("З'їли щось інше");// невідомий тип тварини

        }
    }
    public  void canReproduce(){

    }
    // Якщо тварини одного виду, і кількість тварин не більше maxPerCell, - з'являється дитинка

    public void moveTo(int newX, int newY) {

        this.x = newX;
        this.y = newY;
        this.energy--; // расход энергии на перемещение
        if (this.energy <= 0) {
            this.isAlive = false; // животное умирает от голода
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

    public boolean canAttack(Animal otherAnimal) {

        return false;
    }

    public void attack(Animal otherAnimal) {
    }

    public abstract void canDie();

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