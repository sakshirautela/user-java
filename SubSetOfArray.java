import java.util.*;

public class SubSetOfArray {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList();
        List<Integer> list=new ArrayList();
        getHelp(result,0,list,nums);
        return result;
    }
    private static void getHelp(List<List<Integer>> result, int i, List<Integer> list, int[] nums) {
        if(i>=nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        getHelp(result,i+1,list,nums);
        list.add(nums[i]);
        getHelp(result,i+1,list,nums);
        list.remove(list.size()-1);
    }
    private void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int start){
        resultList.add(new ArrayList<Integer> (tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);

            backtrack(resultList, tempList, nums, i+1);

            tempList.remove(tempList.size() - 1);
        }
    }
    public static void main(String[] args){
        System.out.println(subsets(new int[]{1,2,3}));
    }
}