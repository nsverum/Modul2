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


           default -> {
               return null;
           }
       }
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
        return ration;
    }
    private static Map<Type, Integer> getMousePos() {
        Map<Type, Integer> ration = new HashMap<>();
        ration.put(Type.WOLF, 0);
        ration.put(Type.FOX, 0);
        ration.put(Type.SHEEP, 70);
        ration.put(Type.HORSE, 10);
        ration.put(Type.BEAR, 0);
        ration.put(Type.MOUSE, 0);
        ration.put(Type.RABBIT, 0);
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
        return ration;
    }
}
