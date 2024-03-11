import java.util.* ;
import java.io.*; 
public class MinSubarraySum
{
public static int minSubarraySum(ArrayList<Integer> arr, int n, int k)
    {
        // Write your code here.
        int sum=0;
        int minSum=Integer.MAX_VALUE;
        for(int i=k;i<n;i++){
            while(k>0){
            sum+=arr.get(k);
            k--;
            }
            if(sum<minSum){
                minSum=sum;
            }
        }
        return minSum;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList();
        arr.add(1 );
        arr.add(-4);
        arr.add( 2);
        arr.add( 10);
        arr.add( -2 );
        arr.add(3 );
        arr.add( 1 );
        arr.add( 0 );
        arr.add( -20);
        System.out.println(minSubarraySum(arr,arr.size(),4));
    }
}
