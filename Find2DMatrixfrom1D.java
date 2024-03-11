import java.util.ArrayList;
import java.util.List;

public class Find2DMatrixfrom1D {
    public static List<List<Integer>> findMatrix(int[] nums) {
        int[] temp=new int[201];
        List<List<Integer>> list=new ArrayList();
        for(int i=0;i<nums.length;i++){
            temp[nums[i]]=temp[nums[i]]+1;
            if(list.size()<temp[nums[i]]){
                list.add(new ArrayList<Integer>());
            }
            list.get(temp[nums[i]]-1).add(nums[i]);
        }
        return list;
    }
    public static void main(String[] args){
        System.out.println(findMatrix(new int[]{1,2,3,4,4,5,5}));
    }
}