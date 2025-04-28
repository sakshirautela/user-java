package com.learn.java.problemsolving;

public class MinimumTimetoRepairCars {
    public static void main(String[] args) {
        System.out.println(repairCars(new int[] {}, 5));
    }

    public static long repairCars(int[] ranks, int cars) {
        long l = 1;
        long r = (long) ranks[0] * cars * cars;
        long res = -1;

        while (l <= r) {
            long mid = l + (r - l) / 2; // Avoids overflow
            long required = requiredGet(ranks, mid);

            if (required >= cars) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private static long requiredGet(int[] ranks, long mid) {
        long req = 0;
        for (int rank : ranks) {
            req += (long) Math.sqrt(mid / rank); // Correct formula
        }
        return req;
    }
        public long repairCars2(int[] ranks, int cars) {
            int[] freq = new int[101];
            for (int i : ranks) {
                freq[i]++;
            }
            int minF = 100;
            for (int i = 1; i <= 100; i++) {
                if (0 < freq[i]) {
                    minF = i;
                    break;
                }
            }
            long l = 0, r = minF * (long) cars * cars;
            while (1 < r - l) {
                long mid = (l + r) / 2;
                if (check(freq, cars, mid)) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
            return r;
        }
    
        private boolean check(int[] freq, long cars, long mid) {
            for (int i = 1; 0 < cars && i <= 100; i++) {
                if (freq[i] == 0) continue;
                long t = (long) Math.sqrt((double) mid / i);
                cars -= t * freq[i];
            }
            return cars <= 0;
        }
    
}