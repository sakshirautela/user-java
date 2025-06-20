import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RandomPickwithWeight{
    private List<Integer> runningSums;
    private int totalSum;

    public RandomPickwithWeight(int[] weights) {

        runningSums = new ArrayList<>();
        int runningSum = 0;

        for (int w : weights) {
            runningSum += w;
            runningSums.add(runningSum);
        }

        totalSum = runningSum;
    }

    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(totalSum) + 1;
        int low = 0;
        int high = runningSums.size();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target > runningSums.get(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
// class Solution {

//     public int[] probablities;
//     public int[] probablitiesCp;
//     public Solution(int[] w) {
//         int len = w.length;
//         int[] probablities1 = new int[len];
//         int sum = 0;
//         for (int i=0; i<len; i++) {
//             sum += w[i];
//         }
//         for (int i=0; i<len; i++) {
//             probablities1[i] = (int) Math.round(((double) w[i]/sum) * 100);
//         }
//         this.probablities = probablities1;
//         this.probablitiesCp = probablities1.clone();
//     }
    
//     public int pickIndex() {
//         for (int i=0; i<this.probablitiesCp.length; i++) {
//             if (this.probablitiesCp[i] == 0) {
//                 continue;
//             }
//             this.probablitiesCp[i] = this.probablitiesCp[i] - 1;
//             return i;
//         }
//         this.probablitiesCp = this.probablities.clone();
//         this.probablitiesCp[0] = this.probablitiesCp[0] - 1;
//         return 0;

//     }
// }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */