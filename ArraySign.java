class ArraySign {
    public static int arraySign(int[] nums) {
        int mul=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                return 0;
            }
            else if(nums[i]>0){
                mul*=1;
            }
            else{
                mul*=-1;
            }
        }
        return mul;
    }
    public static void main(String[] args) {
      int[] arr={ -1, -2, -3, -4, 3,2,1};
      System.out.println(arraySign(arr));
    }
}