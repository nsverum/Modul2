import java.util.Arrays;
import java.util.Scanner;

public class View {

    public static void statistic(Service service) {

        String mapString = Arrays.deepToString(service.getMap());
        System.out.println(String.join("\n", mapString.split(", ")));


    }

}
