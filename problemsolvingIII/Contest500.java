package problemsolvingIII;


import java.util.HashMap;

public class Contest500 {
    static void main() {
        int[] arr=minCost(new int[]{-5,-2,3},new int[][]{{0,2},{2,0},{1,2}});
        System.out.println();
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            boolean even = (nums[i] % 2) == 0;
            for (int j = i + 1; j < n; j++) {
                if (even && nums[j] % 2 == 1) {
                    res[i]++;
                } else if (!even && nums[j] % 2 == 0) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    public int sumOfPrimesInRange(int n) {
        int r = reversen(n);
        int res = 0;
        for (int i = Math.min(r, n); i <= Math.max(r, n); i++) {
            if (isPrime(i)) {
                res += i;
            }
        }
        return res;
    }

    private int reversen(int n) {
        int res = 0;
        while (n > 0) {
            int r = n % 10;
            res = res * 10 + r;
            n = n / 10;
        }
        return res;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int maxFixedPoints(int[] nums) {
        int n = nums.length;
        HashMap<String, Integer> set = new HashMap<>();
        return maxFixedPointsUtil(nums, 0, n, 0, set);
    }


    private static int maxFixedPointsUtil(int[] nums, int i, int n, int deleted, HashMap<String, Integer> set) {
        if (i == n) {
            return 0;
        }
        String s = "" + i + deleted;
        if (set.containsKey(s)) {
            return set.get(s);
        }
        int res = 0;
        if (nums[i] == (i - deleted)) {
            res = 1 + maxFixedPointsUtil(nums, i + 1,n, deleted, set);
        } else {
            int keep = maxFixedPointsUtil(nums, i + 1, n,deleted, set);
            int skip = maxFixedPointsUtil(nums, i + 1, n,deleted + 1, set);
            res = Math.max(keep, skip);
        }
        set.put(s, res);
        return res;
    }

    public static int[] minCost(int[] nums, int[][] queries) {
        int n=nums.length;
        int q=queries.length;
        int[] res =new int[q];
        int[] closet = new int[n];
        closet[0]=1;
        closet[n-1]=n-2;
        for (int i=n-2; i>=1; i--) {
            closet[i]=(nums[i+1]-nums[i]>nums[i]-nums[i-1])?i-1:i+1;
        }
        int[] front=new int[n];
        int[] back=new int[n];
        for(int i=1;i<n;i++){
            if(closet[i]==i-1){
                front[i]=front[i-1]+1;
            }else{
                front[i]+=Math.abs(nums[i-1]-nums[i]);
            }
        }
        for(int i=n-2;i>=0;i--){
            if(closet[i]==i+1){
                back[i]=back[i+1]+1;
            }else{
                back[i]+=Math.abs(nums[i+1]-nums[i]);
            }
        }
        int[] cost=new int[n];
        for(int i=n-2;i>=0;i--){
            if(closet[i]==i-1){
                cost[i]=1;
            }
        }
            for(int i=0;i<q;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            if(l<=r){
                res[i]=front[r]-front[l];
            }else{
                res[i]=back[l]-back[r];
            }
        }
        return res;
    }
}
