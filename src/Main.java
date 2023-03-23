import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
            Location[][] locations = new Location[100][20];

            Service service = new Service(locations);
            System.out.println(service);

    }
}