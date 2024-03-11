public class CountingSort {
    public void countSort(int[] nums){
        int largest=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            largest=Math.max(largest, nums[i]);
        }
        int[] count=new int[largest+1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int idx=0;
        for (int i = 0; i < count.length; i++) {
            while(count[i]>0){
                nums[idx]=i;
                idx++;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = { 5, 2, 3, 1};
        CountingSort cs=new CountingSort();
        cs.countSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
