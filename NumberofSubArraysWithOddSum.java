class Solution {

    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int count = 0, prefixSum = 0;
        int oddCount = 0, evenCount = 1;

        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                count += oddCount;
                evenCount++;
            } else {
                count += evenCount;
                oddCount++;
            }

            count %= MOD;
        }

        return count;
    }
}