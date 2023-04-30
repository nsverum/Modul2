import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Service field = new Service(100,20);
//        field.eating();
//        Thread.sleep(3000);
//
//        field.breedAnimals();
//        Thread.sleep(3000);
//
//        field.choseDestination();
//        field.moveAnimals();



        Controller controller = new Controller(100,20,10);
        controller.start();
   }

}