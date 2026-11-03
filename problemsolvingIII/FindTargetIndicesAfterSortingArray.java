package problemsolvingIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    static void main() {

        int[] res=searchRange(new int[]{5,7,7,8,8,10},8);
        System.out.println(res[0]+" "+res[1]);
    }

            public static int[] searchRange(int[] nums, int target) {
                int[] res = {-1, -1};

                res[0] = BinarySearch1(nums, target);
                res[1] = BinarySearch2(nums, target);

                return res;
            }

            // Find first occurrence
            public static int BinarySearch1(int[] nums, int target) {
                int low = 0;
                int high = nums.length - 1;

                while (low < high) {
                    int mid = low + (high - low) / 2;

                    if (nums[mid] < target) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }

                if (nums.length == 0 || nums[low] != target) {
                    return -1;
                }

                return low;
            }

            // Find last occurrence
            public static int BinarySearch2(int[] nums, int target) {
                int low = 0;
                int high = nums.length - 1;

                while (low < high) {
                    int mid = low + (high - low + 1) / 2;

                    if (nums[mid] > target) {
                        high = mid - 1;
                    } else {
                        low = mid;
                    }
                }

                if (nums.length == 0 || nums[low] != target) {
                    return -1;
                }

                return low;
            }
        public List<Integer> targetIndices(int[] nums, int target) {
        int n=nums.length;
        int les=0;
        int freq=0;
        for(int num:nums){
            if(num<target){
                les++;
            }else if(num==target){
                freq++;
            }
        }
        List<Integer> res=new ArrayList<>();
        while(freq>0){
            freq--;
            res.add(les);
            les++;
        }
        return res;
    }
}
