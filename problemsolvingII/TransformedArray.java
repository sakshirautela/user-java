public class TransformedArray {
    static void main() {
        int[] res = constructTransformedArray(new int[]{3,-2,1,1});
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if(val<0){
                val=Math.abs(val);
                int idx=((i-val)%n+n)%n;
                res[i]=nums[idx];
            }else if(val>0){
                int idx=(i+val)%n;
                res[i]=nums[idx];
            }else{
                res[i]=val;
            }
        }
        return res;
    }
        public int[] constructTransformedArrayFast(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = nums[((i + nums[i]) % n + n) % n];
            }
            return ans;
        }
}