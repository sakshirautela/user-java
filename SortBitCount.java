import java.util.*;

class SortBitCount {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, new CountBit());
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        // Remove the following line, as getCountBit is not a static method in SortBitCount.
        // System.out.println(getCountBit(3));
    }

    static class CountBit implements Comparator<Integer> {
        public int getCountBit(int a) {
            int count = 0;
            while (a > 0) {
                count = ((a & 1) != 0) ? count + 1 : count;
                a = a >> 1;
            }
            return count;
        }

        @Override
        public int compare(Integer a, Integer b) {
            if (getCountBit(a) != getCountBit(b)) {
                return getCountBit(a) - getCountBit(b);
            } else {
                return a - b;
            }
        }
    }
}
