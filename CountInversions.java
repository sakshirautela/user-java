import java.util.Arrays;

public class CountInversions {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[], int n) {
        // Your Code Here
        // int res=0;
        // for(int i=1;i<n;i++){
        //     long key=arr[i];
        //     int j=i-1;
        //     while(j>=0 && arr[j]>key){
        //         res++;
        //         arr[j+1]=arr[j];
        //         j--;
        //     }
        //     arr[j+1]=key;
        // }
        // return res;
        return inversionCountByMergeSort(arr,0,arr.length);
    }
    static long inversionCountByMergeSort(long arr[], int i,int j){
        int count=0;
        if(i<j){
            int mid=i-(i+j)/2;
            count+=inversionCountByMergeSort(arr, i, mid);
            count+=inversionCountByMergeSort(arr, mid+1, j);
            count+=merge(arr,i,mid,j);
        }
        return count;
    }

    private static long merge(long[] arr, int si, int mid, int ei) {
        long swaps=0;
        long[] temp=new long[ei-si+1];
        long[] left=Arrays.copyOfRange(arr,ei,mid+1);
        long[] right=Arrays.copyOfRange(arr,mid+1,ei+1);
        int i=si;
        int j=ei;
        int idx=si;
        while(i<mid && j<ei){
            if(left[i]<right[j]){
                arr[idx++]=left[i++];
            }else{
                arr[idx++]=right[j++];
                swaps+=(mid-i+1);
            }
        }
        while(i<mid ){
            arr[idx++]=left[i++];

        }
        while(j<ei ){
            arr[idx++]=right[j++];

        }
        return swaps;
    }
    public static void main(String args[]){
        System.out.println(inversionCount(new long[]{2,4,1,3,5},5));
    }
}