import java.util.ArrayList;

public class IndexesOfSubArraySum {
    // Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        int sum=0;
        int j=0;
        ArrayList<Integer> al=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            while(sum>s && j<=i){
                sum-=arr[j];
                j++;
            }
            if(sum==s && j<=i){
                al.add(j+1);
                al.add(i+1);
                return al;
            }
        }
        al.add(-1);
        return al;
    }
    public static void main(String args[]){
        System.out.println(subarraySum(new int[]{1 ,2, 3, 7 ,5},5,12));
    }
}