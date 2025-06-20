
class ProductArrayExceptSelf{
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int n=nums.length;
        //if(n==1){
            //return new long[]{1};
        //}
        long[] prefix=new long[n];
        long[] suffix=new long[n];
        prefix[0]=nums[0];
        suffix[n]=nums[n];
        long[] res=new long[n];
        for(int i=1;i<n;i++){
            prefix[i]=nums[i]*prefix[i-1];
        }
        for(int i=n-1;i>=0;i--){
            suffix[i]=nums[i]*suffix[i+1];
        }
        res[0]=suffix[1];
        res[n]=prefix[n-1];
        for(int i=1;i<n;i++){
            res[i]=suffix[i+1]*prefix[i-1];
        }
        //return res;

        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();

        
    }
}
