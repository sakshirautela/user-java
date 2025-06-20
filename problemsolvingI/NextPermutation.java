
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n=nums.length;
        // find pivot : left on smaller then right from the right 
        int pivot=-1;
        for (int i = n-2;i>=0; i--) {
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }
        System.out.println(pivot);
        // if pivot not exit revese whole (will get smaller permutation)
        if(pivot==-1){
            reverse(nums, 0, n-1);
            return;
        }
        // find tthe next greater element than pivot from the right and sawp with pivot
        for (int i =n-1; i >pivot; i--) {
            if(nums[i]>nums[pivot]){
                swap(nums, pivot, i);
                break;
            }
        }
        reverse(nums, pivot+1, n-1);

    }
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
    // Helper method to swap two elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]) {
        int[] arr=new int[] { 1,2,3,6,5,4 };
        nextPermutation(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
