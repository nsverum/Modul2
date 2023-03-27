import lombok.Getter;
import lombok.Setter;

import java.util.List;



public abstract class Animal {
    private int x; // координаты животного на острове
    private int y;
    private static Type type;
    private int number;
    private boolean isAlive;
    private String gender; // стать
    List<Animal> animalList;

    public  void canEat() {
        System.out.println("Я поїло");
    }
    public abstract void canReproduce();
    // Якщо тварини одного виду, і кількість тварин не більше maxPerCell, - з'являється дитинка

    public abstract void canDie();
    public void canMove(){

    }
    public void feedAnimal(Animal animal) {
        if (animal.getClass().isAnnotationPresent(Predators.class)) {
            System.out.println("З'їли травоядну тварину");// харчування для хижака
        } else if (animal.getClass().isAnnotationPresent(Herbivore.class)) {
            System.out.println("З'їли траву");// харчування для травоїдної тварини
        } else {
            System.out.println("З'їли щось інше");// невідомий тип тварини
        }
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

    public static Type getType() {
        return type;
    }

    public static void setType(Type type) {
        Animal.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}