import java.util.HashMap;

public class LargestSubarrayWith0Sum {
    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{-31, -48, -90, 54, 20, 95, 6, -86, 22}));
    }

    static int maxLength(int[] arr) {
        // code here
        int result = (arr[0]==0)?1:0;
        int n = arr.length;
        int[] presum = new int[n];
        presum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            presum[i] = presum[i - 1] + arr[i];
            if (presum[i] == 0) {
                result = Math.max(result, i + 1);

            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(presum[i] + " ");
        }
        HashMap<Integer, Integer> sum = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (sum.containsKey(presum[i])) {
                result = Math.max(result, i - sum.get(presum[i]));
            } else {
                sum.put(presum[i], i);
            }
        }
        System.out.println(sum);
        return result;
    }
}
