public class FloorInSortedArray {
    public static void main(String[] args) {
        System.out.println(findFloor(new int[]{1, 2, 8, 10, 10, 12, 19},0));
    }
    public static int findFloor(int[] arr, int x) {
        // code here
        int n=arr.length;
        int max_idx=-1;
        for (int i = 0; i <n ; i++) {
            if(max_idx==-1&&arr[i]<=x){
                max_idx=i;
            }
            if(max_idx!=-1&&arr[i]<=x&&arr[max_idx]<=arr[i]){
                max_idx=Math.max(max_idx,i);
            }
        }
        if(max_idx==-1){
            return -1;
        }
        return max_idx+1;
    }
}
