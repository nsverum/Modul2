import java.util.Arrays;
import java.util.Scanner;

public class View {

    public static void statistic(Service service) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Для початку гри введіть - Старт");
//        String answer = scanner.nextLine();
//        if (answer.equals("Старт")) {
        String mapString = Arrays.deepToString(service.getMap());
        System.out.println(String.join("\n", mapString.split(", ")));


    }

}
