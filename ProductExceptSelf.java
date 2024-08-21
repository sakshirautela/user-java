public class ProductExceptSelf {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        int n=nums.length;
        long[] product=new long[n];
        long pro=1;
        int  getZero=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                getZero++;
            }else{
                pro*=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if(getZero>1){
                product[i]=0;
            }
            else if(nums[i]!=0 && getZero==1){
                product[i]=0;
            }else if(nums[i]==0){
                product[i]=pro;
            }
            else{
                product[i]=pro/nums[i];
            }
        }
        return product;
    }
    public static void main(String args[]){
        long[] arr=productExceptSelf(new int[]{1,2,3});
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}