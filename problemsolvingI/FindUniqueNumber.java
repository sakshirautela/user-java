import java.util.HashMap;

public class FindUniqueNumber {
    public static void main(String[] args) {
        System.out.println(findUnique(new int[] {}));
    }

    public static int findUnique(int[] arr) {
        // code here
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i : arr) {
            if (hs.containsKey(i)) {
                hs.remove(i);
            } else {
                hs.put(i, hs.getOrDefault(i, 0) + 1);
            }
        }
        for (int i : hs.keySet()) {
            return i;
        }
        return 0;
    }

    public static int findUnique2(int[] arr) {

        int total = arr[0];
        for (int i = 1; i < arr.length; i++) {
            total ^= arr[i];
        }

        return total;
    }
}
