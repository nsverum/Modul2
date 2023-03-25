import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {

    private final Location[][] map;
    public Service(int width, int height) {
        this.map = new Location[100][20];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = new Location();
            }
        }
    }
    public Location getLocation(int x, int y) {
        return map[y][x];
    }

    public void setLocation(int x, int y, Location location) {
        map[y][x] = location;
    }
}

