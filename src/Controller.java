import java.util.Scanner;
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

            for (int i = 1; i < 10; i++) {
                System.out.println("  ");
                System.out.println("Step " + i);
                // while (isRunning) {
                service.eating();
                service.breedAnimals();
                service.choseDestination();
                service.moveAnimals();

                Thread.sleep(2000);
                 View.statistic(service);
            }
            service.close();

    }

    public void stop() {
        isRunning = false;
    }
}