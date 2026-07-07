package problemsolvingIII;

public class BinarySearchableCount {
    static void main() {
        System.out.println(binarySearchable(new int[]{1,2,3}));
    }

    public  static int binarySearchable(int[] arr) {
        // code here
        int res=0;
        for(int i=0;i<arr.length;i++){
            if(binarySearch(arr,arr[i])){
                res++;
            }
        }
        return res;
    }
    public static boolean binarySearch(int[] arr, int el){
        int n = arr.length;
        int low = 0;
        int high = n-1 ;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == el){
                return true;
            }
            if (arr[mid] < el) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}