package problemsolvingIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class MakeLexicographicallySmallestArraybySwappingElements {
    static void main() {
        int[] res=lexicographicallySmallestArray(new int[]{1,5,3,9,8},2);
        for(int i:res){
            System.out.print(i+" ");
        }
    }
    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        HashMap<Integer, LinkedList<Integer>> map=new HashMap<>();
        int group=1;
        HashMap<Integer,Integer> groups=new HashMap<>();
        int[] arr=nums.clone();
        Arrays.sort(arr);
        map.put(group,new LinkedList<>());
        map.get(group).add(arr[0]);
        groups.put(arr[0],group);
        for(int i=1;i<n;i++){
            if (arr[i] - arr[i - 1] > limit) {
                group++;
                map.put(group, new LinkedList<>());
            }
            map.get(group).add(arr[i]);
            groups.put(arr[i],group);
        }
        for(int i=0;i<n;i++){
            nums[i]=map.get(groups.get(nums[i])).removeFirst();
        }
        return nums;
    }
    public static int[] lexicographicallySmallestArrayFast(int[] nums, int limit) {
        int n = nums.length;
        long[] sorted = new long[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = ((long) nums[i] << 32) | (i & 0xffffffffL);
        }

        Arrays.sort(sorted);

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = (int) (sorted[i] >>> 32);
        }

        int start = 0;

        while (start < n) {
            int end = start;

            while (end + 1 < n &&
                    values[end + 1] - values[end] <= limit) {
                end++;
            }

            int size = end - start + 1;
            int[] indices = new int[size];

            for (int i = 0; i < size; i++) {
                indices[i] = (int) sorted[start + i];
            }

            Arrays.sort(indices);

            for (int i = 0; i < size; i++) {
                nums[indices[i]] = values[start + i];
            }

            start = end + 1;
        }

        return nums;
    }
}
