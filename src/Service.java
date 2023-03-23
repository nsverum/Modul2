import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
    Location[][] locations;
    Map<Type, List<Animal>> animal;
    public Service(Location[][] locations) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                locations[i][j] = new Location(1000, animal);
                System.out.println(locations[i][j]);
            }

        }

    }
}

