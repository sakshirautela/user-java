import java.util.HashSet;
import java.util.Set;

public class MaximumXORoftwoNumbersinanArray {
    public static void main(String[] args) {
        int[] nums = { 3, 10, 5, 25, 2, 8 };
        System.out.println(maxXor(nums)); // Output: 28
    }

    public static int maxXor(int[] arr) {
        // // code here
        // int result=0;
        // int n=arr.length;
        // for (int i = 0; i < n; i++) {
        // for (int j = i+1; j < n; j++) {
        // if((arr[i]^arr[j])>result){
        // result=arr[i]^arr[j];
        // }
        // }
        // }
        // return result;
        int mask = 0, max = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int n : arr)
                set.add(mask & n);

            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
