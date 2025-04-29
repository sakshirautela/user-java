
import java.util.HashMap;
import java.util.Map;

public class TuplewithSameProduct {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productcount = new HashMap<>();
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int mul = nums[i] * nums[j];

                if (productcount.containsKey(mul)) {
                    count += productcount.get(mul);
                }
                productcount.put(mul, productcount.getOrDefault(mul, 0) + 1);
            }
        }
        return count * 8;
    }
    
    public int tupleSameProduct2(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int product = nums[i]*nums[j];
                count+=(map.getOrDefault(product,0)*8);
                map.merge(product,1,Integer::sum);
            }
        }
        return count;
    }
}
