package problemsolvingIII;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class SortbySetBitCount {
    static void main() {
        int[] arr = {5, 2, 3, 9, 4, 6, 7, 15, 32};
        System.out.println(sortBySetBitCount(arr));
    }

    static ArrayList<Integer> sortBySetBitCount(int[] arr) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>((a, b) -> b-a);
        for (int j : arr) {
            int count = Integer.bitCount(j);
            map.putIfAbsent(count, new ArrayList<>());
            map.get(count).add(j);
        }
        for(int key : map.keySet()) {
            res.addAll(map.get(key));
        }
        return res;
    }
}