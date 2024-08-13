public class MinimumIncrementToMakeArraysUnique {
    public static int minIncrementForUnique(int[] nums) {
        int maxEl=0;
        maxEl=findMax(nums,maxEl);
        int[] count=new int[maxEl+1];
        for (int i : nums) {
            count[i]++;
        }
        int add=0;
        int res=0;
        for (int i = 0; i < count.length; i++) {
            int el=count[i];
            while(el>1){
                el--;
                add++;
                res-=i;
            }
            if(add>0 && count[i]==0){
                res+=i;
                add--;
            }
        }
        while(add>0){
            res+=maxEl+1;
            add--;
            maxEl++;
        }
        return res;
    }
    private static int findMax(int[] nums,int maxEl) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>maxEl){
                maxEl=nums[i];
            }
        }
        return maxEl;
    }
    public static void main(String args[]){
        System.out.println(minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }
}
