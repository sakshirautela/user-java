import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class FindDifference {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>(nums1.length);
        HashSet<Integer> diffs = new HashSet<>();
        HashSet<Integer> diffs2 = new HashSet<>();
        for (int i = 0; i < nums1.length|| i<nums2.length; i++){
            if(i<nums1.length){
                diffs.add(nums1[i]);
            }
            if(i<nums2.length){
                diffs2.add(nums2[i]);
            }
        }
        HashSet<Integer> temp = new HashSet<Integer>(diffs);
        diffs.removeAll(diffs2);
        diffs2.removeAll(temp);
        result.add(0,new ArrayList<>(diffs));        
        result.add(1,new ArrayList<>(diffs2));

        return result;
    }
    public static List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>(nums1.length);
        HashSet<Integer> diffs = new HashSet<>();
        HashSet<Integer> diffs2 = new HashSet<>();
        for (int i = 0; i < nums1.length|| i<nums2.length; i++){
            if(i<nums1.length){
                diffs.add(nums1[i]);
            }
            if(i<nums2.length){
                diffs2.add(nums2[i]);
            }
        }
        HashSet<Integer> temp = new HashSet<Integer>(diffs);
        diffs.removeAll(diffs2);
        diffs2.removeAll(temp);
        result.add(0,new ArrayList<>(diffs));        
        result.add(1,new ArrayList<>(diffs2));

        return result;
    }
    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1,2,3},new int[]{2,4,6}));
    }
}