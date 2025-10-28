public class TakingMaximumEnergyFromtheMysticDungeon {
    public static void main(String[] args) {
        System.out.println(maximumEnergy(new int[]{5,-10,4,3,5,-9,9,-7},2));
    }
    public static int maximumEnergy(int[] energy, int k) {
        int n=energy.length;
        int[] dp=new int[n];
        dp[0]=energy[0];
        for (int i = 1; i <n ; i++) {
            if(i-k>=0)
                dp[i]=Math.max(dp[i-k]+energy[i],energy[i]);
            else
                dp[i]=energy[i];
        }
        int ans=0;
        for (int i = 0; i <n ; i++) {
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}