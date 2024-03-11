class ProductArrayExceptSelf{
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int n=nums.length-1;
        int[] prefix=new int[nums.length];
        int[] suffix=new int[nums.length];
        prefix[0]=nums[0];
        suffix[n]=nums[n];
        int[] res=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            prefix[i]=nums[i]*prefix[i-1];
        }
        for(int i=0;i<nums.length;i++){
            System.out.print(prefix[i]+" ");
        }
        System.out.println();

        for(int i=n-1;i>=0;i--){
            suffix[i]=nums[i]*suffix[i+1];
        }
        for(int i=0;i<nums.length;i++){
            System.out.print(suffix[i]+" ");
        }
        System.out.println();
        res[0]=suffix[1];
        res[n]=prefix[n-1];
        for(int i=1;i<n;i++){
            res[i]=suffix[i+1]*prefix[i-1];
        }

        for(int i=0;i<nums.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();

        
    }
}
