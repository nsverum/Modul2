import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller {
    public Service service;
    private final ExecutorService executorService;
    private boolean isRunning = true;

    public Controller() {
        executorService = Executors.newFixedThreadPool(10);
    }

    public void start() {
        service = new Service(100,20);
        for (int i = 0; i < 2 && isRunning; i++){
        //while (isRunning) {
            executorService.execute(() -> {
                try {
                    service.eating();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            executorService.execute(service::moveAnimals);
            executorService.execute(() -> {
                try {
                    service.breedAnimals();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           /* if (  ) {
                stop();
            }*/
        }
    }

    public void stop() {
        isRunning = false;
        executorService.shutdown();
    }
}