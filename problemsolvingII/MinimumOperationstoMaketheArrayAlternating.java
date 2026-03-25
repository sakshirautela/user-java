import java.util.HashMap;

public class MinimumOperationstoMaketheArrayAlternating {
    static void main() {
        System.out.println(minimumOperations(new int[]{2, 2, 2, 2}));
    }

    public static int minimumOperations(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> even = new HashMap<>();
        HashMap<Integer, Integer> odd = new HashMap<>();
        int evenVal1 = -1, evenMax1 = 0, evenMax2 = 0;
        int oddVal1 = -1, oddMax1 = 0, oddMax2 = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                int freq = even.getOrDefault(nums[i], 0) + 1;
                even.put(nums[i], freq);
                if (freq > evenMax1) {
                    evenMax2 = evenMax1;
                    evenMax1 = freq;
                    evenVal1 = nums[i];
                } else if (freq > evenMax2) {
                    evenMax2 = freq;
                }
            } else {
                int freq = odd.getOrDefault(nums[i], 0) + 1;
                odd.put(nums[i], freq);
                if (freq > oddMax1) {
                    oddMax2 = oddMax1;
                    oddMax1 = freq;
                    oddVal1 = nums[i];
                } else if (freq > oddMax2) {
                    oddMax2 = freq;
                }
            }
        }
        int e = (len + 1) / 2;
        int o = len / 2;
        if (evenVal1 != oddVal1) {
            return (e - evenMax1) + (o - oddMax1);
        }
        if(evenMax1+oddMax1==len){
            return e-evenMax1+oddMax1;
        }
        return Math.min((e - evenMax1) + (o - oddMax2), (e - evenMax2) + (o - oddMax1)
        );
    }
}
