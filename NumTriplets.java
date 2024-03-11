import java.util.*;
class NumTriplets {
    public static int helper(int[] nums1, int[] nums2) {
        int count=0;
        HashMap<Long, Integer> hm=new HashMap<Long, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            long a = (long)(nums1[i] * nums1[i]);
            hm.put(a,hm.getOrDefault(a, 0)+1);
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int k = i+1; k < nums2.length; k++) {
                long a = (long)(nums2[i] * nums2[i]);
                if(hm.containsKey(a)){
                    count=count+hm.get(a);
                }
            }
        }
        return count;
    }
    public static int numTriplets(int[] nums1, int[] nums2){
        return helper(nums1, nums2)+helper(nums2, nums1);
    }

    public static void main(String[] args) {
        int[] nums1={ 43024, 99908};
        int[] nums2={ 1864};
        System.out.println(numTriplets(nums1,nums2));
    }
}