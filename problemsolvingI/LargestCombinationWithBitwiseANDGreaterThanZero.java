
public class LargestCombinationWithBitwiseANDGreaterThanZero {
    public int largestCombination2(int[] candidates) {
        int[] ans = new int[32];
        for (int x : candidates) {
            find(x, ans);
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = Math.max(res, ans[i]);// traverse the bit array and check the max value
        }
        return res;
    }

    public void find(int n, int[] ans) {

        int j = 31;// index for updating the values in bit array
        while (n > 0) {
            int a = (n & 1);// for checking if bit is set or not
            ans[j] += a;
            n >>= 1;// left shift the given no
            j--;
        }
    }

    public static int largestCombination(int[] candidates) {
        int maxCount = 0; // Variable to track the maximum count of set bits.
        for (int i = 0; i < 24; i++) {
            int count = 0; // Count of numbers with the i-th bit set.
            for (int num : candidates) {
                if ((num & (1 << i)) != 0) { // Check if the i-th bit is set.
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count); // Update the maximum count.
        }
        return maxCount;
    }

    public static void main(String args[]) {
        System.out.print(largestCombination(new int[] { 16, 17, 71, 62, 12, 24, 14 }));
    }
}
