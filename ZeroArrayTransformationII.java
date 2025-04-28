package com.learn.java.problemsolving;

public class ZeroArrayTransformationII {
    public static void main(String[] args) {
        System.out.println(minZeroArray(new int[] { 2 }, new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }));
    }

    public static int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, sum = 0, k = 0;
        int[] differenceArray = new int[n + 1];
        // Iterate through nums
        for (int index = 0; index < n; index++) {
            // Iterate through queries while current index of nums cannot equal zero
            while (sum + differenceArray[index] < nums[index]) {
                k++;

                // Zero array isn't formed after all queries are processed
                if (k > queries.length) {
                    return -1;
                }
                int left = queries[k - 1][0], right = queries[k - 1][1], val = queries[k - 1][2];

                // P rocess start and end of range
                if (right >= index) {
                    differenceArray[Math.max(left, index)] += val;
                    differenceArray[right + 1] -= val;
                }
            }
            // Update prefix sum at current index
            sum += differenceArray[index];
        }
        return k;
    }
    public int minZeroArray2(int[] nums, int[][] queries) {
        int left = 0, right = queries.length;

        // Zero array isn't formed after all queries are processed
        if (!currentIndexZero(nums, queries, right)) return -1;

        // Binary Search
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (currentIndexZero(nums, queries, middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // Return earliest query that zero array can be formed
        return left;
    }

    private boolean currentIndexZero(int[] nums, int[][] queries, int k) {
        int n = nums.length, sum = 0;
        int[] differenceArray = new int[n + 1];

        // Process query
        for (int queryIndex = 0; queryIndex < k; queryIndex++) {
            int left = queries[queryIndex][0], right =
                queries[queryIndex][1], val = queries[queryIndex][2];

            // Process start and end of range
            differenceArray[left] += val;
            differenceArray[right + 1] -= val;
        }

        // Check if zero array can be formed
        for (int numIndex = 0; numIndex < n; numIndex++) {
            sum += differenceArray[numIndex];
            if (sum < nums[numIndex]) return false;
        }
        return true;
    }
    public int minZeroArray3(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] differenceArray = new int[n + 1];

        int differentArrayPrefixSum = 0;
        int q = 0;
        for (int i = 0; i < n; i++) {
            while (differentArrayPrefixSum + differenceArray[i] < nums[i]) {
                q++;
                if (q > queries.length) return -1;

                int[] nextQuery = queries[q - 1];
                int left = nextQuery[0], right = nextQuery[1], val = nextQuery[2];
                if (right >= i) {
                    differenceArray[Math.max(left, i)] += val;
                    differenceArray[right + 1] -= val;
                }
            }
            differentArrayPrefixSum += differenceArray[i];
        }
        return q;
    }
}