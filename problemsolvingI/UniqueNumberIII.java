import java.util.HashMap;

public class UniqueNumberIII {
    public static void main(String[] args) {
        System.out.println(getSingle(new int[]{}));
    }
    public static int getSingle(int[] arr) {
        // code here
         HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : arr) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        int res=0;
        for (int i : hm.keySet()) {
            if (hm.get(i) == 1) {
                res = i;
            }
        }
        return res;
    }
}
