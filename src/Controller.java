import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller {
    public Service service;
    private boolean isRunning = true;

    public Controller(int width, int height,int numThreads ) {
        service = new Service(width, height, numThreads);
    }

    public void start() throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++){

     // while (isRunning) {
          service.eating();
          service.breedAnimals();;
          service.choseDestination();
          service.moveAnimals();
            System.out.println("End of iteration " + i);
      }

    }

    public void stop() {
        isRunning = false;
    }
}