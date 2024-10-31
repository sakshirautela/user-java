import java.util.*;

public class MaxDistanceBetweenSameElementsGFG {
    public static int maxDistance(int[] arr) {
        // Code here
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = n - 1; i >= 0; i--) {
            if (!hm.containsKey(arr[i])) {
                hm.put(arr[i], i);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i])) {
                result = Math.max(hm.get(arr[i]) - i, result);
                hm.remove(arr[i]);
            }
        }
        return result;
    }

    public int maxWidthRamp2(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];

        // Fill rightMax array with the maximum values from the right
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int left = 0, right = 0;
        int maxWidth = 0;

        // Traverse the array using left and right pointers
        while (right < n) {
            // Move left pointer forward if current left exceeds rightMax
            while (left < right && nums[left] > rightMax[right]) {
                left++;
            }
            maxWidth = Math.max(maxWidth, right - left);
            right++;
        }

        return maxWidth;
    }
        public int maxWidthRamp3(int[] nums) {
            int low = 1, high = nums.length-1, res = 0;
    
            while(low <= high) {
                int mid = low + (high - low)/2;
                if(possible(nums, mid)) {
                    res = mid;
                    low = mid + 1;
                } else high = mid - 1;
            }
            return res;
        }
    
        private boolean possible(int[] nums, int width) {
            int i=0,j=width;
            int min = nums[i];
            while(j < nums.length) {
                if(nums[j] >= min) return true;
                j++;
                min = Math.min(min, nums[++i]);
            }   
            return false;
        }

    public static void main(String args[]) {
        System.out.println(maxDistance(new int[] { 1, 1, 2, 2, 2, 1 }));
    }
}
