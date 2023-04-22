import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Service field = new Service(100,20);
        //field.moveAnimals();
        field.eating();
        Thread.sleep(3000);
        field.breedAnimals();
        Thread.sleep(3000);
        field.moveAnimals();



        Controller controller = new Controller();
        //controller.start();
   }

}