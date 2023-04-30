import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller {
    public Service service;
    private final ExecutorService executorService;
    private boolean isRunning = true;

    public Controller(int width, int height,int numThreads ) {
        executorService = Executors.newFixedThreadPool(numThreads);
        service = new Service(width, height);
    }

    public void start() {

       while (isRunning) {

           executorService.execute(() -> {
               try {
                   service.eating();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           });
            executorService.execute(() -> {
                try {
                    service.breedAnimals();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
           executorService.execute(() -> service.choseDestination());
           executorService.execute(() -> service.moveAnimals());

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