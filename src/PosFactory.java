import java.util.HashMap;
import java.util.Map;

public class PosFactory {
    public static  Map<Type, Integer> ration(Type type) {
       switch (type){
           case WOLF -> {
               return getWolfPos();
           }
           case BEAR -> {
               return getBearPos();
           }
           case FOX -> {
               return getFoxPos();
           }
           case SHEEP -> {
               return getSheepPos();
           }
           case HORSE -> {
               return getHorsePos();
           }
           case MOUSE -> {
               return getMousePos();
           }
           case RABBIT -> {
               return getRabbitPos();
           }
           case SNAKE -> {
               return getSnakePos();
           }
           case EAGLE -> {
               return getEaglePos();
           }
           case DEER -> {
               return getDeerPos();
           }
           case GOAT -> {
               return getGoatPos();
           }
           case BOAR -> {
               return getBoarPos();
           }
           case BUFFALO -> {
               return getBuffaloPos();
           }
           case DUCK -> {
               return getDuckPos();
           }
           case CATERPILLAR -> {
               return getCaterpillarPos();
           }

           default -> {
               return null;
           }
       }
    }
    private static Map<Type, Integer> getCaterpillarPos() {
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 0);
        ration.put(Type.HORSE, 0);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 0);
        ration.put(Type.RABBIT, 0);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.DEER, 0);
        ration.put(Type.GOAT, 0);
        ration.put(Type.BOAR, 0);
        ration.put(Type.BUFFALO, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DUCK, 0);
        ration.put(Type.CATERPILLAR, 0);

        return ration;
    }
    private static Map<Type, Integer> getDuckPos() {
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 0);
        ration.put(Type.HORSE, 0);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 0);
        ration.put(Type.RABBIT, 0);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.DEER, 0);
        ration.put(Type.GOAT, 0);
        ration.put(Type.BOAR, 0);
        ration.put(Type.BUFFALO, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DUCK, 0);
        ration.put(Type.CATERPILLAR, 90);

        return ration;
    }
    private static Map<Type, Integer> getBuffaloPos() {
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 0);
        ration.put(Type.HORSE, 0);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 0);
        ration.put(Type.RABBIT, 0);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.DEER, 0);
        ration.put(Type.GOAT, 0);
        ration.put(Type.BOAR, 0);
        ration.put(Type.BUFFALO, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DUCK, 0);
        ration.put(Type.CATERPILLAR, 0);

        return ration;
    }
    private static Map<Type, Integer> getBoarPos() {
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 0);
        ration.put(Type.HORSE, 0);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 10);
        ration.put(Type.RABBIT, 0);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.DEER, 0);
        ration.put(Type.GOAT, 0);
        ration.put(Type.BOAR, 0);
        ration.put(Type.BUFFALO, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DUCK, 0);
        ration.put(Type.CATERPILLAR, 90);

        return ration;
    }
    private static Map<Type, Integer> getGoatPos() {
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 0);
        ration.put(Type.HORSE, 0);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 0);
        ration.put(Type.RABBIT, 0);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.DEER, 0);
        ration.put(Type.GOAT, 0);
        ration.put(Type.BOAR, 0);
        ration.put(Type.BUFFALO, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DUCK, 0);
        ration.put(Type.CATERPILLAR, 0);
        return ration;
    }
    private static Map<Type, Integer> getDeerPos() {
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 0);
        ration.put(Type.HORSE, 0);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 0);
        ration.put(Type.RABBIT, 0);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.DEER, 0);
        ration.put(Type.GOAT, 0);
        ration.put(Type.BOAR, 0);
        ration.put(Type.BUFFALO, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DUCK, 0);
        ration.put(Type.CATERPILLAR, 0);
        return ration;
    }
    private static Map<Type, Integer> getEaglePos() {
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 10);
        ration.put(Type.SHEEP, 0);
        ration.put(Type.HORSE, 0);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 90);
        ration.put(Type.RABBIT, 90);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.DEER, 0);
        ration.put(Type.GOAT, 0);
        ration.put(Type.BOAR, 0);
        ration.put(Type.BUFFALO, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DUCK, 80);
        ration.put(Type.CATERPILLAR, 0);
        return ration;
    }
    private static Map<Type, Integer> getSnakePos() {
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 15);
        ration.put(Type.SHEEP, 0);
        ration.put(Type.HORSE, 0);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 0);
        ration.put(Type.RABBIT, 20);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.DEER, 0);
        ration.put(Type.GOAT, 0);
        ration.put(Type.BOAR, 0);
        ration.put(Type.BUFFALO, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DUCK, 10);
        ration.put(Type.CATERPILLAR, 0);

        return ration;
    }

    private static Map<Type, Integer> getRabbitPos() {
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 0);
        ration.put(Type.HORSE, 0);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 0);
        ration.put(Type.RABBIT, 0);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DEER, 0);
        ration.put(Type.GOAT, 0);
        ration.put(Type.BOAR, 0);
        ration.put(Type.BUFFALO, 0);
        ration.put(Type.DUCK, 0);
        ration.put(Type.CATERPILLAR, 0);
        return ration;
    }
    private static Map<Type, Integer> getMousePos() {
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 0);
        ration.put(Type.HORSE, 0);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 0);
        ration.put(Type.RABBIT, 0);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DEER, 0);
        ration.put(Type.GOAT, 0);
        ration.put(Type.BOAR, 0);
        ration.put(Type.BUFFALO, 0);
        ration.put(Type.DUCK, 0);
        ration.put(Type.CATERPILLAR, 90);

        return ration;
    }
    private static Map<Type, Integer> getWolfPos() {
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 70);
        ration.put(Type.HORSE, 10);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 80);
        ration.put(Type.RABBIT, 60);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DEER, 15);
        ration.put(Type.GOAT, 60);
        ration.put(Type.BOAR, 15);
        ration.put(Type.BUFFALO, 10);
        ration.put(Type.DUCK, 40);
        ration.put(Type.CATERPILLAR, 0);

        return ration;
    }
    private static  Map<Type, Integer> getBearPos(){
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 70);
        ration.put(Type.HORSE, 70);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 90);
        ration.put(Type.RABBIT, 80);
        ration.put(Type.SNAKE, 80);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DEER, 80);
        ration.put(Type.GOAT, 70);
        ration.put(Type.BOAR, 50);
        ration.put(Type.BUFFALO, 20);
        ration.put(Type.DUCK, 60);
        ration.put(Type.CATERPILLAR, 0);

        return ration;
    }
    private static  Map<Type, Integer> getFoxPos(){
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 0);
        ration.put(Type.HORSE, 0);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 90);
        ration.put(Type.RABBIT, 70);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DEER, 0);
        ration.put(Type.GOAT, 0);
        ration.put(Type.BOAR, 0);
        ration.put(Type.BUFFALO, 0);
        ration.put(Type.DUCK, 10);
        ration.put(Type.CATERPILLAR, 40);

        return ration;
    }
    private static  Map<Type, Integer> getSheepPos(){
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 0);
        ration.put(Type.HORSE, 0);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 0);
        ration.put(Type.RABBIT, 0);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DEER, 0);
        ration.put(Type.GOAT, 0);
        ration.put(Type.BOAR, 0);
        ration.put(Type.BUFFALO, 0);
        ration.put(Type.DUCK, 0);
        ration.put(Type.CATERPILLAR, 0);

        return ration;
    }
    private static  Map<Type, Integer> getHorsePos(){
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 0);
        ration.put(Type.HORSE, 0);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 0);
        ration.put(Type.RABBIT, 0);
        ration.put(Type.SNAKE, 0);
        ration.put(Type.EAGLE, 0);
        ration.put(Type.DEER, 0);
        ration.put(Type.GOAT, 0);
        ration.put(Type.BOAR, 0);
        ration.put(Type.BUFFALO, 0);
        ration.put(Type.DUCK, 0);
        ration.put(Type.CATERPILLAR, 0);

        return ration;
    }
}
