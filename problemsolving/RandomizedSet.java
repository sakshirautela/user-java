
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class RandomizedSet {

    // Data structures
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random rand;

    // Constructor
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    // Inserts a value into the set, returns true if the set did not already contain the specified element.
    public boolean insert(int val) {
        // If value already exists, return false
        if (map.containsKey(val)) {
            return false;
        }

        // Add value to list and map
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    // Removes a value from the set, returns true if the set contained the specified element.
    public boolean remove(int val) {
        // If value doesn't exist, return false
        if (!map.containsKey(val)) {
            return false;
        }

        // Get the index of the value to remove
        int index = map.get(val);

        // Swap the last element with the element to remove
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove the last element from list and map
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    // Get a random element from the set
    public int getRandom() {
        // Generate a random index between 0 and the size of the list - 1
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));  // true
        System.out.println(obj.insert(2));  // true
        System.out.println(obj.getRandom()); // Random: 1 or 2
        System.out.println(obj.remove(1));  // true
        System.out.println(obj.insert(3));  // true
        System.out.println(obj.getRandom()); // Random: 2 or 3
    }
}
