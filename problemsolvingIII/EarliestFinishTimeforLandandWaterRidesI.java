package problemsolvingIII;

import java.util.Arrays;

public class EarliestFinishTimeforLandandWaterRidesI {
    static void main() {
        System.out.println(earliestFinishTime(new int[]{}, new int[]{}, new int[]{}, new int[]{}));
    }

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int l = landStartTime.length;
        int w = waterStartTime.length;
        int lands=Integer.MAX_VALUE;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<l;i++){
            lands=Math.min(lands,landStartTime[i]+landDuration[i]);
        }
        int waters=Integer.MAX_VALUE;
        for(int i=0;i<w;i++){
            waters=Math.min(waters,waterStartTime[i]+waterDuration[i]);
            ans = Math.min(ans,Math.max(lands,waterStartTime[i])+waterDuration[i]);

        }
        for(int i=0;i<l;i++){
            ans=Math.min(ans,Math.max(waters,landStartTime[i])+landDuration[i]);
        }
        return ans;
    }
}
