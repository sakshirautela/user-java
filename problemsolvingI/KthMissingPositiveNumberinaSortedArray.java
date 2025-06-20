
public class KthMissingPositiveNumberinaSortedArray {
    public static void main(String[] args) {
        System.out.println(kthMissing(new int[]{2, 3, 4, 7, 11},5));
    }
    public static int kthMissing(int[] arr, int k) {
        // code here
        int idx=0;
        int n=arr.length;
        int fix=n+k;
        for (int i = 1; i < fix; i++) {
            if(idx<n && arr[idx]==i){
                idx++;
            }else{
                k--;
                if(k==0){
                    return i;
                }
            }
        }
        return 0;
        // int left = 0, right = arr.length - 1;
        
        // // Perform binary search
        // while (left <= right) {
        //     int mid = left + (right - left) / 2;
        //     int missing = arr[mid] - (mid + 1);
            
        //     if (missing < k) {
        //         left = mid + 1; // Move to the right
        //     } else {
        //         right = mid - 1; // Move to the left
        //     }
        // }
        
        // // At the end, `left` points to the first element greater than the k-th missing number
        // return left + k;
    }
}
