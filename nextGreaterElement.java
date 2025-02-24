import java.util.ArrayList;

public class nextGreaterElement {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n=arr.length;
        ArrayList<Integer> al=new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int idx=i+1;
            while (idx<n && arr[idx]<=arr[i]) {
                idx++;
            }
            if(idx<n){
                al.add(arr[idx]);
            }else{
                al.add(-1);
            }
        }
        return al;
    }
}