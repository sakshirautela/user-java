/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
public class MountainArray {
    public static int find(int[] mountainArr){
        int start=0;
        int end=mountainArr.length-1;
        int idx=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(end>mid && mountainArr[mid]<mountainArr[mid+1]){
                start=mid+1;
            }
            else if(start<mid && mountainArr[mid]<mountainArr[mid-1]){
                end=mid-1;
            }
            else{
                idx=mid;
                return idx;
            }
        }
        if(idx==-1){
            return end;
        }
        return idx;
    }
    public static int search(int[] arr,int low,int high,int target){
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    public static int searchDes(int[] arr,int low,int high,int target){
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    public static int findInMountainArray(int target,int[] arr){
        int idx=find(arr);
        if(arr[idx]<target){
            return -1;
        }
        else if(arr[idx]==target){
            return idx;
        }
        
        int a=search(arr,0,idx,target);
        if(a!=-1){
            return a;
        }
        int b=search(arr,idx+1,arr.length,target);
        if(b!=-1){
            return b;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(findInMountainArray(5,new int[]{5,4,3,2,1}));

    }
}