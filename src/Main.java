import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
       Service service = new Service(100,20);
      // service.iterate();
        // service.moveAnimals();
        service.breedAnimals();

    }

}