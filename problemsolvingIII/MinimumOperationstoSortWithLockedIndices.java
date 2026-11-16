package problemsolvingIII;

public class MinimumOperationstoSortWithLockedIndices {
    static void main() {
        System.out.println(minOperations(new int[]{},new int[]{},9));
    }
    public static int minOperations(int[] nums, int[] locked, int k) {
        int n=nums.length;
        int res=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if(nums[j]>nums[j+1]){
                    if(locked[j]+ locked[j+1]<=k){
                        k-=locked[j];
                        res+=locked[j+1];
                        res+=locked[j];
                        locked[j]=0;
                        k-=locked[j+1];
                        locked[j+1]=0;
                    }else{
                        return -1;
                    }
                    int a=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=a;
                    res++;
                }
            }
        }
        return res;
    }
}
