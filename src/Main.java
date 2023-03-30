import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service(10,10);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Location currentLocation = new Location();
               System.out.println(service.getMap()[i][j]);
            }
        }



    }

}