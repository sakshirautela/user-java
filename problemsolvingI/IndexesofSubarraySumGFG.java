import java.util.ArrayList;

public class IndexesofSubarraySumGFG {
    public static void main(String[] args) {

    }

    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int sum = 0;
        int n = arr.length;
        int j = 0, i = 0;
        ArrayList<Integer> al = new ArrayList<Integer>();
        while (i<=j && j < n) {
            if(sum<target){
                sum+=arr[j];
                j++;
            }else if(sum>target){
                sum-=arr[i];
                i++;
            }else{
                al.add(i);
                al.add(j);
            }
        }
        al.add(-1);
        return al;
    }
}