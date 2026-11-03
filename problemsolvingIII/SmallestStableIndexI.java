package problemsolvingIII;

public class SmallestStableIndexI {
    static void main() {
        System.out.println(firstStableIndex(new int[]{5,0,1,4},3));
    }
    public static int firstStableIndex(int[] nums, int k) {
   int n=nums.length;
   int max=nums[0];
   int[] min=new int[n];
   min[n-1]=nums[n-1];
   for(int i=n-2;i>=0;i--){
       min[i]=Math.min(min[i+1],nums[i]);
   }
   for(int i=0;i<n;i++){
       max=Math.max(max,nums[i]);
       int diff=max-min[i];
       if(diff<=k){
           return i;
       }
   }
   return -1;
    }
}
