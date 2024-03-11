import java.util.*;
public class CombinationSum {
    static List<List<Integer>> result;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        result= new ArrayList<List<Integer>>();
        List<Integer> res=new ArrayList<Integer>();
        fun(candidates, target, 0,0, res);
        return result;
    }
    private static void fun(int[] candidates, int target,int idx,int sum,List<Integer>list) {
        if(sum==target) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if(sum>target || idx==candidates.length){
            return;
        }
        list.add(candidates[idx]);
        fun(candidates, target,idx,sum+candidates[idx],list);
        list.remove(list.size()-1);
        fun(candidates, target,idx+1,sum,list);
    }
    public static void main(String[] args){
        System.out.println(combinationSum(new int[]{ 2, 3, 5},8));
    }
}