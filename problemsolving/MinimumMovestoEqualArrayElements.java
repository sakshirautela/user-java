
public class MinimumMovestoEqualArrayElements {
    public static void main(String[] args) {
        System.out.println(minMoves(new int[] { 1, 2, 3 }));
    }

    public static int minMoves(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int sum = 0;
        for (int i : nums) {
            sum += i;
            min = Math.min(i, min);
        }
        return (sum - (n * min));
    }

    public int minMoves3(int[] nums) {
        int max = Integer.MAX_VALUE;
        int count = 0;
        for (int num : nums) {
            if (num < max) {
                max = num;
            }
        }
        for (int num : nums) {
            count += num - max;
        }
        return count;
    }
}
