import java.util.* ;
import java.io.*; 
public class MaxSubSumKConcat {

	public static long maxSubSumKConcat(ArrayList<Integer> arr, int n, int k) {
		// Write your code here.
		//ArrayList<Integer> result=new ArrayList<>();
		long sum=0;
		long result=Integer.MIN_VALUE;
		//while(k>0){
			for (int index = 0; index < n*k; index++) {
				sum+=arr.get(index%n);
				result=Math.max(sum,result);

				if(sum<0){
					sum=0;
				}
			}
			//k--;
		//}
		return result;
	}
    public static void main(String[] args) {
        ArrayList<Integer> array=new ArrayList();
        array.add(1);
        array.add(-3);
        System.out.println(maxSubSumKConcat(array,array.size(),3));
    }
}