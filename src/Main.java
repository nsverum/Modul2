import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Controller controller = new Controller(2,2,10);
        controller.start();
   }

}