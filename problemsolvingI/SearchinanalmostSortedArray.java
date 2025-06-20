
// User function Template for Java
public class SearchinanalmostSortedArray {
    public static void main(String[] args) {
        System.out.println(findTarget(new int[]{},4));
    }
    public static int findTarget(int arr[], int target) {
        // code here
        int start =0;
        int end=arr.length - 1;
        
        while (start<=end){
            int mid = start+(end - start)/2;
        
            if (arr[mid]==target){
                return mid;
            }
            else if ( mid<arr.length-1 && (arr[mid+1]==target)){
                return mid+1;
            }
            else if ( mid>0 && (arr[mid-1]==target)){
                return mid-1;
            }
            else if (arr[mid]<target){
                start=mid+2;
            }
            else {
                end=mid-2;
            }
        }
        return -1;
        
    }
}