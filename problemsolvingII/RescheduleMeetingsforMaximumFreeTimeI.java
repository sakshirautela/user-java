
public class RescheduleMeetingsforMaximumFreeTimeI {
    public static void main(String[] args) {
        System.out.println(maxFreeTimeM(21, 1, new int[] {7,10,16}, new int[] {10,14,18}));
    }

    public static int maxFreeTimeM(int eventTime, int k, int[] startTime, int[] endTime) {
       int n = startTime.length;
        int st=0;
        int[] sum=new int[n+2];
        for(int i=1;i<=n;i++){
            sum[i]=startTime[i-1]-st+sum[i-1];
            st=endTime[i-1];
        }

        sum[n+1]=eventTime-st+sum[n];

        for(int i=0;i<=n+1;i++){
            System.out.print(sum[i]+" ");
        }
        System.out.println();
        int result=0;
        for(int i=k;i<=n+1;i++){
            result=Math.max(result,sum[i]-sum[i-k]);
        }
        return result;
    }
    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int result = 0;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + endTime[i] - startTime[i];
        }
        for (int i = k - 1; i < n; i++) {
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            int left = i == k - 1 ? 0 : endTime[i - k];
            result = Math.max(result, right - left - (presum[i + 1] - presum[i - k + 1]));
        }
        return result;
    }

    int maxFreeTime2(int eventTime, int k, int[] startTime, int[] endTime) {
        int[] gap = new int[startTime.length + 1];
        gap[0] = startTime[0];
        for (int i = 1; i < startTime.length; ++i)
            gap[i] = startTime[i] - endTime[i - 1];
        gap[startTime.length] = eventTime - endTime[endTime.length - 1];
        int ans = 0, sum = 0;
        for (int i = 0; i < gap.length; ++i) {
            sum += gap[i] - ((i >= k + 1) ? gap[i - (k + 1)] : 0);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}