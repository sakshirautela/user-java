import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {
    static List<List<Integer>> res;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        helperCombination(list,candidates,target,0,0);
        return res;
    }

    private static void helperCombination(List<Integer> list, int[] candidates, int target, int sum, int i) {
        if(sum==target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum>target || i==candidates.length){
            return ;
        }
        for(int j=i;j<candidates.length;j++){
            if(j>i && candidates[j]==candidates[j-1]){
                continue;
            }
            list.add(candidates[j]);
            helperCombination(list,candidates,target,sum+candidates[j],j+1);
            list.remove(list.size()-1);
        }
    }
    public static void main(String args[]){
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
}