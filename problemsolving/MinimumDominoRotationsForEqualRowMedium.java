public class MinimumDominoRotationsForEqualRowMedium {

    public static void main(String[] args) {
        System.out.println(minDominoRotations(new int[] { 2, 1, 2, 4, 2, 2 }, new int[] { 5, 2, 6, 2, 3, 2 }));
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int swaps = Integer.MAX_VALUE;
        int n = tops.length;
        for (int val = 1; val <= 6; val++) {
            boolean isSwap = true;
            int bottom = 0, top = 0;
            for (int index = 0; index < n; index++) {
                if (bottoms[index] != val && tops[index] != val) {
                    isSwap = false;
                    break;
                } else if (bottoms[index] != val) {
                    bottom++;
                } else if (tops[index] != val) {
                    top++;
                }
            }
            if (isSwap) {
                swaps = Math.min(swaps, Math.min(bottom, top));
            }
        }
        return (swaps == Integer.MAX_VALUE) ? -1 : swaps;
    }

    private int helper(int[] tops, int[] bottoms, int val) {
        int top_res = 0, bottom_res = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != val && bottoms[i] != val) {
                return -1;
            } else if (tops[i] != val) {
                top_res++;
            } else if (bottoms[i] != val) {
                bottom_res++;
            }
        }
        return Math.min(top_res, bottom_res);
    }

    public int minDominoRotations2(int[] tops, int[] bottoms) {

        int ans = -1;
        for (int i = 1; i < 7; i++) {
            int cur_ans = helper(tops, bottoms, i);

            if (cur_ans != -1 && (ans == -1 || ans > cur_ans)) {
                ans = cur_ans;
            }
        }
        return ans;
    }
}