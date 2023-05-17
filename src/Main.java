import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Для початку гри введіть - Старт");
//        String answer = scanner.nextLine();
//       if (answer.equals("Старт")) {
//            System.out.println("Введіть ширину поля: ");
//            int width = scanner.nextInt();
//            System.out.println("Введіть довжину поля: ");
//            int height = scanner.nextInt();
//            System.out.println("Починаємо:");
//            Thread.sleep(1000);
            Controller controller = new Controller(10, 5, 10);
            controller.start();
        //}
   }

}