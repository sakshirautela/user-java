void main() {
    System.out.println(minSwaps(new int[]{41, 18, 19, 38, 38, 19}, new int[]{22, 39, 19, 7, 39, 19}));
}

public static int minSwaps(int[] nums, int[] forbidden) {
    int n = nums.length;
    int maxfreq = 0;
    int match = 0;
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Integer> freq2 = new HashMap<>();
    for (int i = 0; i < n; i++) {
        if (nums[i] == forbidden[i]) {
            match++;
            maxfreq = Math.max(freq.getOrDefault(nums[i],0), maxfreq);
        }
        freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        freq2.put(forbidden[i], freq.getOrDefault(forbidden[i], 0) + 1);

    }
    System.out.println(freq);
    System.out.println(freq2);
    System.out.println(match);
    System.out.println((match + 1) / 2);
    for (int i : freq.keySet()) {
        if (freq.get(i) + freq2.getOrDefault(i, 0) > n) {
            return -1;
        }
    }
    return Math.max(((match + 1) / 2), maxfreq);
}
