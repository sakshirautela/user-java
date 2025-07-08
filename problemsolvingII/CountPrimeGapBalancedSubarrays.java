import java.util.ArrayDeque;
import java.util.ArrayList;

import java.util.List;

import java.util.Arrays;
import java.util.Deque;

public class CountPrimeGapBalancedSubarrays {
    public int primeSubarray(int[] nums, int k) {
       int n = nums.length;
        int U = Arrays.stream(nums).max().orElse(0);
        boolean[] isPrime = new boolean[U + 1];
        Arrays.fill(isPrime, true);
        if (U >= 0) isPrime[0] = false;
        if (U >= 1) isPrime[1] = false;
        for (int i = 2; i * i <= U; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= U; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> pos = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= U && isPrime[nums[i]]) {
                pos.add(i);
                vals.add(nums[i]);
            }
        }

        int P = pos.size();
        if (P < 2) return 0;

        long[] rc = new long[P];
        long[] pref = new long[P];
        for (int j = 0; j < P; j++) {
            int nxt = (j + 1 < P ? pos.get(j + 1) : n);
            rc[j] = nxt - pos.get(j);
            pref[j] = rc[j] + (j > 0 ? pref[j - 1] : 0);
        }

        long ans = 0;
        Deque<Integer> minDq = new ArrayDeque<>();
        Deque<Integer> maxDq = new ArrayDeque<>();
        int j = 0;

        for (int i = 0; i < P; i++) {
            while (j < P) {
                int v = vals.get(j);
                int currMax = Math.max(maxDq.isEmpty() ? Integer.MIN_VALUE : vals.get(maxDq.peekFirst()), v);
                int currMin = Math.min(minDq.isEmpty() ? Integer.MAX_VALUE : vals.get(minDq.peekFirst()), v);
                if (currMax - currMin <= k) {
                    while (!minDq.isEmpty() && vals.get(minDq.peekLast()) > v) minDq.pollLast();
                    minDq.offerLast(j);
                    while (!maxDq.isEmpty() && vals.get(maxDq.peekLast()) < v) maxDq.pollLast();
                    maxDq.offerLast(j);
                    j++;
                } else {
                    break;
                }
            }
            int best = j - 1;
            if (best >= i + 1) {
                long leftChoices = pos.get(i) - (i > 0 ? pos.get(i - 1) : -1);
                long sumRight = pref[best] - pref[i];
                ans += leftChoices * sumRight;
            }
            if (!minDq.isEmpty() && minDq.peekFirst() == i) minDq.pollFirst();
            if (!maxDq.isEmpty() && maxDq.peekFirst() == i) maxDq.pollFirst();
        }

        return (int) ans; 
    }
}