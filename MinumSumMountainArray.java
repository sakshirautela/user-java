class MinumSumMountainArray {
    public int minimumSum(int[] nums) {
        int sum=-1;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i] < nums[j] && nums[k] < nums[j]){
                        sum=((nums[i]+nums[j]+nums[k])<sum)?nums[i]+nums[j]+nums[k]:sum;
                    }
                }
            }
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println();
    }
}