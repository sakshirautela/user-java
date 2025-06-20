import java.util.HashMap;

public class CountPairsSuminMatrices {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[][]{{}},new int[][]{{}},3));
    }

    static int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int mat[] : mat2) {
            for (int i : mat) {
                freq.put(i, freq.getOrDefault(i, 0) + 1);
            }
        }
        int res = 0;
        for (int mat[] : mat1) {
            for (int i : mat) {
                if (freq.containsKey(x - i)) {
                    res += freq.get(x - i);
                }
            }
        }
        return res;
    }
}
