public class XORAfterRangeMultiplicationQueriesI {
    static void main() {
        System.out.println(xorAfterQueries(new int[]{1,1,1}, new int[][]{{0,2,1,4}}));
    }

    public static int xorAfterQueries(int[] nums, int[][] queries) {
        int mod= 1000000007;
        for(int[] query : queries) {
            int idx=query[0];
            while(idx<=query[1]){
                long mul= (long) nums[idx] *query[3];
                nums[idx]= Math.toIntExact((mul) % mod);
                idx+=query[2];
            }
        }
        int xor=0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
