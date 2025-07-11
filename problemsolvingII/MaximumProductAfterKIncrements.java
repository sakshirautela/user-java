import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumProductAfterKIncrements {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[] { 0, 4 }, 4));
    }

    public static int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        while (!pq.isEmpty() && k > 0) {
            pq.add(pq.remove() + 1);
            k--;
        }
        long mul = 1;
        int mod = 1000000007;
        while (!pq.isEmpty()) {
            mul = ((mul % mod) * ((pq.remove()) % mod)) % mod;
        }
        return (int) mul;
    }
    /*
     * Greedy.
     * Binary search.
     * 
     * 大int*大int, 要注意long.
     * 
     * 元素个数一定, 元素总和一定, 济贫最优 => 拉平尽量多的矮的.
     * (prefixSum[p] + k) / (p + 1) <= nums[p + 1]
     * =>
     * (p + 1) * nums[p + 1] - prefixSum[p] >= k
     * =>
     * diff[i] = i * nums[i] - prefixSum[i - 1], diff[i]表示拉平前i个元素到nums[i]需要的投资,
     * 要求diff[i] <= k.
     * diff显然是一个单调增函数, 必然可以用二分法确定临界位置p.
     */

    /*
     * n = nums.length:
     * TC = O(n*log2(n)).
     * AS = O(n):
     * Heap = O(n).
     * Stack = O(1).
     */
    public int maximumProductFast(int[] nums, int k) {
        int MODULE = 1_000_000_000 + 7;
        int n = nums.length;
        Arrays.sort(nums);
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        long[] diff = new long[n];
        diff[0] = 0;
        for (int i = 1; i < n; i++) {
            diff[i] = (long) nums[i] * i - prefixSum[i - 1];
        }
        int p = binarySearch(diff, k, 0, n - 1);
        long total = prefixSum[p] + k;
        long each = total / (p + 1);
        long extra = total % (p + 1);
        long res = 1;
        for (int i = 0; i < extra; i++) {
            res = res * (each + 1) % MODULE;
        }
        for (long i = extra; i <= p; i++) {
            res = res * each % MODULE;
        }
        for (int i = p + 1; i < n; i++) {
            res = res * nums[i] % MODULE;
        }
        return (int) res;
    }

    private int binarySearch(long[] diff, int k, int left, int right) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (diff[mid] <= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (diff[right] <= k) {
            return right;
        } else {
            return left;
        }
    }

    // /*
    // Greedy.
    // Min heap.
    // */

    // /*
    // n = nums.length:
    // TC = O(n*log2(n)).
    // AS = O(n):
    // Heap = O(n).
    // Stack = O(1).
    // */
    // class Solution {
    // public int maximumProduct(int[] nums, int k) {
    // int MODULE = 1_000_000_000 + 7;
    // int n = nums.length;
    // if (n == 1) {
    // return (nums[0] + k) % MODULE;
    // }
    // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // for (int num : nums) {
    // minHeap.offer(num);
    // }
    // while (k > 0) {
    // int num1 = minHeap.poll();
    // int num2 = minHeap.poll();
    // int diff = Math.min(k, num2 - num1 + 1);
    // minHeap.offer(num1 + diff);
    // minHeap.offer(num2);
    // k -= diff;
    // }
    // long res = 1;
    // while (!minHeap.isEmpty()) {
    // res = res * minHeap.poll() % MODULE;
    // }
    // return (int) res;
    // }
    // }
}