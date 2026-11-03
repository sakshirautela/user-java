package problemsolvingIII;

public class MinimumOperationstoSortaPermutation {
    static void main() {
        System.out.println(minOperations(new int[]{1,2,0}));
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int peak = 0;
        int pi=-1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                pi=i;
                peak++;
            }
        }
        if(peak==0 && nums[0] > nums[n - 1]){
            return 1;
        }
        if (nums[0] > nums[n - 1]) {
            peak++;
        }
        if (peak == n - 1) {
            return 0;
        } else if (peak > 1) {
            return -1;
        }
        pi++;
        if(pi >n/2){
            return (1+(pi-n/2));
        }
        return (pi+2);
    }
}
