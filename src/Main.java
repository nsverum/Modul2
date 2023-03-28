import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Service service = new Service(100,20);
        service.moveAnimals();

        //Service service = new Service(100, 20);
       // service.iterate();
    }
}