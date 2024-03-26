public class ContiguousArrays {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int prefix[]=new int[n];
        int suffix[]=new int[n];
        prefix[0]=(nums[0]==0)?0:1;
        suffix[0]=(nums[n-1]==0)?0:1;
        for(int i=1;i<n;i++){
            prefix[0]=prefix[i-1]+((nums[0]==0)?0:1);
        }
        for(int i=n-2;i>=1;i--){
            suffix[0]=suffix[i+1]+((nums[0]==0)?0:1);
        }
        int res=-1;
        for(int i=0;i<n;i++){
            if(prefix[i]==suffix[i+1]){
                res=Math.max(i+2,res);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
}