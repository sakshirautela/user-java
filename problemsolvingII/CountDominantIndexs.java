public class CountDominantIndexs {
    static void main() {
        System.out.println(dominantIndices(new int[]{53,89}));
    }
    public static int dominantIndices(int[] nums) {
        int n=nums.length;
        int[] p=new int[n];
        p[n-1]=nums[n-1];
        int c=0;
        for(int i=n-2;i>=0;i--){
            p[i]=p[i+1]+nums[i];
        }
        for(int i=0;i<n-1;i++){
            if(p[i+1]/(n-i-1)<nums[i]){
                c++;
            }
        }
        return c;
    }

}
