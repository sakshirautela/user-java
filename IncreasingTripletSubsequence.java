public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        int second=Integer.MAX_VALUE;
        int first=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=first && nums[i]<second){
                first=nums[i];
            }
            else if(nums[i]<=second && nums[i]>first){
                second=nums[i];
            }
            else if(nums[i]>first && nums[i]>second){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(increasingTriplet(new int[]{ 1, 2, 3, 4,5}));
    }
}