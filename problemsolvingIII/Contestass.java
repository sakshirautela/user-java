package problemsolvingIII;

import java.util.*;

public class Contestass {
    static void main() {
        System.out.println(maximumSaleItems(new int[][]{{1, 2}}, 9));
//        int[] arr = maximumMEX(new int[]{0, 1, 0});
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
    }

    public static int digitFrequencyScore(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        while (n > 0) {
            int a = n % 10;
            map.put(a, map.getOrDefault(a, 0) + 1);
            n /= 10;
        }
        int sum = 0;
        for (int key : map.keySet()) {
            sum += map.get(key) * key;
        }
        return sum;
    }

    public static int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] gain = new int[n];
        for (int i = 0; i < n; i++) {
            gain[i] = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    gain[i]++;
                }
            }
        }
       return maximumSaleItemsHelper(gain,items,0,n,budget);
//        int[][] dp = new int[n + 1][budget + 1];
//        dp[0][0] = 1;
//        for (int j = 1; j <= budget; j++) {
//            for (int i = 1; i <= n; i++) {
//                dp[i][j] = dp[i - 1][j];
//                if ((j - items[i - 1][1]) >= 0) {
////                    dp[i][j] = Math.max(dp[i][j], gain[i - 1] + dp[i][j - items[i - 1][1]]);
//                    dp[i][j] = Math.max(dp[i][j], dp[i][j-items[i - 1][1]]);
//                }
//            }
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= budget; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        return dp[n][budget];
    }

    private static int maximumSaleItemsHelper(int[] gain, int[][] items, int i, int n, int budget) {
        if (i == n) {
            return 0;
        }
        if(budget<=0){
            return 0;
        }
        int a=0;
        if(budget-items[i][1]>=0){
            a=maximumSaleItemsHelper(gain, items, i, n, budget-items[i][1]);
        }
        int b=0;
        if(budget-items[i][1]>=0){
           b= maximumSaleItemsHelper(gain, items, i+1, n, budget-items[i][1])+gain[i];
        }
        return Math.max(a,b)+1;
    }

    public static int[] maximumMEX(int[] nums) {
        int n = nums.length;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            max = Math.max(max, i);
        }

        TreeSet<Integer> not = new TreeSet<>();
        for (int i = 0; i <= max + 1; i++) {
            if (!map.containsKey(i)) {
                not.add(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int mex = not.first();
            if (mex == 0) {
                list.add(0);
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                    not.add(nums[i]);
                }
                i++;
            } else {
                Set<Integer> set = new HashSet<>();
                while (i < n && set.size() < mex) {
                    if (nums[i] < mex) {
                        set.add(nums[i]);
                    }
                    map.put(nums[i], map.get(nums[i]) - 1);
                    if (map.get(nums[i]) == 0) {
                        map.remove(nums[i]);
                        not.add(nums[i]);
                    }
                    i++;
                }
                list.add(mex);
            }
        }
        int[] ans = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            ans[j] = list.get(j);
        }
        return ans;
    }
}

