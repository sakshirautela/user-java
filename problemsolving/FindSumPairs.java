import java.util.HashMap;

class FindSumPairs {
    int[] nums1, nums2;
    HashMap<Integer, Integer> freq = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int x : nums2) increaseFreq(x, 1);
    }
    private void increaseFreq(int key, int inc) {
        freq.put(key, freq.getOrDefault(key, 0) + inc);
    }
    public void add(int index, int val) {
        increaseFreq(nums2[index], -1);  // Remove old one
        nums2[index] += val;
        increaseFreq(nums2[index], 1);  // Count new one
    }
    public int count(int tot) {
        int ans = 0;
        for (int a : nums1)
            ans += freq.getOrDefault(tot - a, 0); // a + b = tot -> b = tot - a
        return ans;
    }
}
/*
 * class FindSumPairs {

    private final int[] nums2;
    private Map<Integer, Integer> numToCount1;
    private Map<Integer, Integer> numToCount2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        numToCount1 = new TreeMap<>();
        numToCount2 = new HashMap<>();
        for (int j : nums1) {
            numToCount1.merge(j, 1, Integer::sum);
        }

        for (int j : nums2) {
            numToCount2.merge(j, 1, Integer::sum);
        }

        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        int valueAtIndex = nums2[index];
        Integer currentCount = numToCount2.get(valueAtIndex);
        if (currentCount == 1) {
            numToCount2.remove(valueAtIndex);
        } else {
            numToCount2.put(valueAtIndex, currentCount - 1);
        }

        nums2[index] += val;
        int newValue = valueAtIndex + val;
        numToCount2.merge(newValue, 1, Integer::sum);
    }

    public int count(int tot) {
        int count = 0;
        for (Map.Entry<Integer, Integer> numToCount : numToCount1.entrySet()) {
            Integer number = numToCount.getKey();
            int search = tot - number;
            if (search < 0) {
                break;
            }
            Integer countInSecondArr = numToCount2.get(search);
            if (countInSecondArr != null) {
                count += numToCount.getValue() * countInSecondArr;
            }
        }
        return count;
    }
}


 */
