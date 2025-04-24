import java.util.HashMap;

public class UniqueNumberII {
    public static void main(String[] args) {

    }

    public int[] singleNum(int[] arr) {
        // Code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : arr) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        int res[] = new int[2];
        int idx = 0;
        for (int i : hm.keySet()) {
            if (hm.get(i) == 1) {
                res[idx++] = i;
            }
        }
        return res;
    }
}