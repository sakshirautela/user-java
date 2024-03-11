import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

class ContainsNearbyAlmostDuplicate {
    static class Info implements Comparable<Info> {
        int value;
        int idx;

        public Info(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        public int compareTo(Info s) {
            return this.value - s.value;
        }

    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        boolean res = false;
        int start = 0;
        int end = 1;
        ArrayList<Info> al = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            al.add(new Info(nums[i], i));
        }
        // while (start<= end && end<nums.length) {
        //     if(start != end){
        //         if()
        //     }
        // }
        for (int j = 0; j < nums.length; j++) {
            System.out.print(al.get(j).value+" ");            
            System.out.print(al.get(j).idx+" ");
            System.out.println();
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1 };
        System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));
    }

}