import java.util.HashMap;

public class MinimumSwapstoAvoidForbiddenValues {
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{}, new int[]{}));
    }

    public static int minSwaps(int[] nums, int[] forbidden) {
        int n = nums.length;
        int maxfreq = 0;
        int match = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> freq2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == forbidden[i]) {
                match++;
                maxfreq=Math.max(freq.get(nums[i]),maxfreq);
            }
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            freq2.put(forbidden[i], freq.getOrDefault(forbidden[i], 0) + 1);

        }
        for (int i:freq.keySet()) {
            if(freq2.get(i)+freq2.getOrDefault(i,0)>n){
                return -1;
            }
        }
        return Math.max((match+1)/2,maxfreq);
    }
}
