package problemsolvingIII;

public class LeftandRightSumDifferences {
    static void main() {
int[] ans=leftRightDifference(new int[]{10,4,8,3});
for(int i:ans){
    System.out.print(i+" ");
}
    }
    public int[] leftRightDifferenceFast(int[] nums) {
        int leftSum = 0, rightSum = 0, n = nums.length;
        for(int num : nums) rightSum += num;
        for(int i = 0; i < n; i++) {
            int val = nums[i];
            rightSum -= val;
            nums[i] = Math.abs(leftSum - rightSum);
            leftSum += val;
        }
        return nums;
    }
    public static int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] left =new int[n];
        int[] right=new int[n];
        for(int i=1;i<n;i++){
                left[i]=left[i-1]+nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]+nums[i+1];
        }
        for(int i=0;i<n;i++){
            ans[i]=Math.abs(left[i]-right[i]);
        }
        return ans;
    }
}
