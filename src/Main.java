import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Service field = new Service(100,20);
        //field.moveAnimals();
        field.eating();


        Controller controller = new Controller();
        //controller.start();
   }

}