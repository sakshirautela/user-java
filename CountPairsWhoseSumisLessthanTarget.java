import java.util.ArrayList;
import java.util.List;

public class CountPairsWhoseSumisLessthanTarget {
    public static void main(String[] args) {
        System.out.println(countPairs(new ArrayList<Integer>(),3));
    }
    public static int countPairs(List<Integer> nums, int target) {
        int result=0;
        int n=nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if((nums.get(i)+nums.get(j))<target){
                    result++;
                }
            }
        }
        return result;
    }
}