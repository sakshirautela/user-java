import java.util.*;

public class PremutationsII {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
    public static  List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for (int num : nums) {
            curr.add(num);
        }
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        permuteUniqueHelper(set, 0, n, curr);
        System.out.println(set);
        for (List<Integer>s:set){
            result.add(s);
        }
        return result;
    }

    private static void permuteUniqueHelper(HashSet<List<Integer>> set, int i, int n, List<Integer> curr) {
        if(i==n){
            set.add(new ArrayList<>(curr));
            return ;
        }
        for (int j = i; j < n; j++) {
            Collections.swap(curr,i,j);
            permuteUniqueHelper(set,i+1,n,curr);
            Collections.swap(curr,j,i);
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> perm = new ArrayList<>();
        build(nums, perm, 0);
        return perm;
    }

    public void build(int[] nums, List<List<Integer>> perm, int idx) {
        if (idx == nums.length) {
            List<Integer> li = new ArrayList<>();
            for (int n : nums)
                li.add(n);
            perm.add(li);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            int f = 0;
            for (int j = idx; j < i; j++) {
                if (nums[j] == nums[i]) {
                    f = 1;
                    break;
                }
            }
            if (f == 1)
                continue;
            int t = nums[i];
            nums[i] = nums[idx];
            nums[idx] = t;
            build(nums, perm, idx + 1);
            t = nums[i];
            nums[i] = nums[idx];
            nums[idx] = t;
        }
    }
}