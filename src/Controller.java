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

       while (isRunning) {
            executorService.execute(() -> {
                try {
                    service.eating();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            executorService.execute(service::choseDestination);
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