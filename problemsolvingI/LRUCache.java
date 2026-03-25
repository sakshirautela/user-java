
import java.util.*;

public class LRUCache {
    //    private static int capacity;
//    private static LinkedHashMap<Integer, Integer> cache;
//    LRUCache(int cap) {
//        capacity = cap;
//        cache = new LinkedHashMap<Integer,Integer>(cap, 0.75f, true) {
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//                return size() > capacity;
//            }
//        };
//    }
//    public static int get(int key) {
//        return cache.getOrDefault(key, -1);
//    }
//    public static void put(int key, int value) {
//        cache.put(key, value);
//    }
    static HashMap<Integer, Integer> chache;
    static Deque<Integer> lru;
    static int capacity;

    public LRUCache(int capacity) {
        chache = new HashMap<>();
        lru = new LinkedList<>();
        this.capacity = capacity;
    }

    public static int get(int key) {
        if (chache.containsKey(key)) {
            lru.offerFirst(key);
            return chache.get(key);
        }
        return -1;
    }

    public static void put(int key, int value) {
        if (chache.size() < capacity) {
            lru.offerFirst(key);
            chache.put(key, value);
            return;
        }
        if (!lru.isEmpty()) {
            int k = lru.pollLast();
            chache.remove(k);
            chache.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
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
