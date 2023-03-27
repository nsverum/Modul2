import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {

    private final Location[][] map;
    private int width;
    private int height;
    public Service(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new Location[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = new Location();
            }
        }
       /* for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++)
                System.out.println(map[i][j]);
            System.out.println();
        }*/
    }
    public void iterate () {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
            Location currentLocation = map[i][j];
            Thread locationThread = new Thread(() -> {
                //  логіка для кожної локації

                currentLocation.addAnimal(currentLocation.getAnimalMap()); //


            });
            locationThread.start();
        }
       }
    }

}

