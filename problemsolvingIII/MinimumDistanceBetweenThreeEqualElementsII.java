package problemsolvingIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumDistanceBetweenThreeEqualElementsII {
    static void main() {
        System.out.println(minimumDistance(new int[]{1,2,1,1,3}));
    }

    public static int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> el = new HashMap<>();
        for (int i = 0; i < n; i++) {
            el.putIfAbsent(nums[i], new ArrayList<>());
            el.get(nums[i]).add(i);
        }
        int result = Integer.MAX_VALUE;
        for(int num:el.keySet()){
            if(el.get(num).size()>=3){
                List<Integer> list = el.get(num);
                for(int i=2;i<list.size();i++){
                    result=Math.min(result,Math.abs(list.get(i)-list.get(i-2)));
                }
                if(result==0){
                    return 0;
                }
            }
        }
        return (result==Integer.MAX_VALUE?-1:result*2);
    }
}