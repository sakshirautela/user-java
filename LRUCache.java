import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private static int capacity;
    private static LinkedHashMap<Integer, Integer> cache;
    LRUCache(int cap) {
        capacity = cap;
        cache = new LinkedHashMap<Integer,Integer>(cap, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    public static int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    public static void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
      
        put(1, 1);
        put(2, 2);
        System.out.println(get(1));
        put(3, 3);
        System.out.println(get(2));
        put(4, 4);
        System.out.println(get(1));
        System.out.println(get(3));
        System.out.println(get(4));
    }
}