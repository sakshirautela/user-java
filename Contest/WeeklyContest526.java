package Contest;

public class WeeklyContest526 {
    static void main() {
//        System.out.println(minMergedInteger(new int[]{34,7,11,11}));
        //System.out.println(minimumMaxValue(4,2,8));
        System.out.println(minOperations(new int[]{2,1,3,4}, new int[]{0,1,0,1}, 1));
    }

    public static int minMergedInteger(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i += 2) {
            int a = nums[i];
            int b = nums[i + 1];
            long c = mergeInt(a, b);
            min = Math.toIntExact(Math.min(c, min));
        }
        return min;
    }

    private static long mergeInt(int b, int a) {
        if (a >= 1000) {
            b *= 10000;
        } else if (a >= 100) {
            b *= 1000;
        } else if (a >= 10) {
            b *= 100;
        } else {
            b *= 10;
        }
        return a + b;
    }

    public static long minimumMaxValue(int n, int index, int value) {
        int val = (value % 2 == 0) ? 2 : 3;
        int res = 0;
        for (int j = 0; j < n; j++) {
            res = val + 2 * (n - (j) - 1);
            if (j == index && value != res) {
                return -1;
            }
        }
        return res;
    }

    public static int minOperations(int[] nums, int[] locked, int k) {
        int n = nums.length;
        int op = 0;
        int[] o={k};
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n-1; j++) {
                if(nums[j] > nums[j+1]) {
                    if(checkedUnloacked(j, locked, o) || checkedUnloacked(j + 1, locked, o)){
                        return -1;
                    }
                    int a=nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = a;
                    op++;
                }
            }
        }
        return op;
    }

    private static boolean checkedUnloacked(int i, int[] locked, int[] k) {
        if(locked[0] == 0){
            return false;
        }else {
            if(k[0]==0){
                return true;
            }else{
                k[0]--;
                locked[i]=0;
            }
        }
        return false;
    }
}
