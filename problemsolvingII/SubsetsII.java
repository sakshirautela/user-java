import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> map = new HashSet<>();
        map.add(new ArrayList<>());
        res.add(new ArrayList<>());
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            List<Integer> li = new ArrayList<>();
            getSubSet(li, nums,i, n,map,res);
        }
        return res;
    }

    private static void getSubSet(List<Integer> li, int[] nums, int i, int n, HashSet<List<Integer>> map, List<List<Integer>> res) {
        if(i==n){
            return ;
        }
        li.add(nums[i]);
        if (!map.contains(li)) {
            map.add(new ArrayList<>(li));
            res.add(new ArrayList<>(li));
        }
        getSubSet(li, nums, i+1,n,map,res);
        li.removeLast();
        getSubSet(li, nums, i+1,n,map,res);
    }
    public List<List<Integer>> subsetsWithDup2(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        f(ans, new int[nums.length], nums, 0, 0);
        return ans;
    }

    void f(List<List<Integer>> ans, int[] path, int[] nums, int i, int size){
        if( i == nums.length ){
            List<Integer> list = new ArrayList<>();

            for( int j = 0 ; j < size ; j ++ ){
                list.add(path[j]);
            }

            ans.add(list);

        } else {
            // i is the current char index
            int j = i + 1;
            while( j < nums.length && nums[i] == nums[j] ){
                //next char
                j++;
            }

            f(ans, path, nums, j, size);

            for(; i < j ; i++ ){
                path[size] = nums[i];
                size++;
                f(ans, path, nums, j, size);
            }
        }
    }
}


/*class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i >= nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[i]);
        dfs(i + 1);
        int x = t.remove(t.size() - 1);
        while (i + 1 < nums.length && nums[i + 1] == x) {
            ++i;
        }
        dfs(i + 1);
    }
}
*/