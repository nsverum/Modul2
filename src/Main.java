import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Controller controller = new Controller(100,20,10);
        controller.start();
   }

}