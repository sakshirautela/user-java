import java.util.Arrays;

public class MaximumLengthofPairChain {
    static void main() {
        System.out.println(findLongestChain(new int[][]{{7,9},{4,5},{7,9},{-7,-1},{0,10},{3,10},{3,6},{2,3}}));
    }
        public static int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

            int count = 0;
            int prevEnd = -10001;

            for (int[] pair : pairs) {
                if (pair[0] > prevEnd) {
                    count++;
                    prevEnd = pair[1];
                }
            }
            return count;
        }
}
