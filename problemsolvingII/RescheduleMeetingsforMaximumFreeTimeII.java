public class RescheduleMeetingsforMaximumFreeTimeII {
    public static void main(String[] args) {
        System.out.println(maxFreeTimeM(5, new int[] { 1,3 }, new int[] { 2,5}));
    }

    public static int maxFreeTimeM(int eventTime, int[] startTime, int[] endTime) {
       int n = startTime.length;
        int st=0;
        int[] gap=new int[n+1];
        boolean[] isFree=new boolean[eventTime];
        for(int i=0;i<n;i++){
            gap[i]=startTime[i]-st;
            isFree[endTime[i]-startTime[i]]=true;
            st=endTime[i];
        }
        gap[n]=eventTime-st;
        int result=0;
        for(int i=1;i<=n;i++){
            result=Math.max(gap[i]+gap[i-1],result);
        }
        return result;
    }

    public static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;

        int[] gaps = new int[n + 1];
        int left = 0;
        for (int i = 0; i < n; i++) {
            int gap = startTime[i] - left;
            gaps[i] = gap;
            left = endTime[i];
        }

        gaps[n] = eventTime - endTime[n - 1];
        int[] prefixGap = new int[n];
        int[] suffixGap = new int[n];

        prefixGap[0] = gaps[0];
        for (int i = 1; i < n; i++) {
            prefixGap[i] = Math.max(prefixGap[i - 1], gaps[i]);
        }

        suffixGap[n - 1] = gaps[n];
        for (int i = n - 2; i >= 0; i--) {
            suffixGap[i] = Math.max(suffixGap[i + 1], gaps[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int curr = gaps[i] + gaps[i + 1];

            int barSize = endTime[i] - startTime[i];

            boolean isValid = false;
            if (i - 1 >= 0) {
                isValid = prefixGap[i - 1] >= barSize;
            }

            if (i + 1 < n) {
                isValid = isValid || suffixGap[i + 1] >= barSize;
            }

            if (isValid) {
                curr += barSize;
            }

            ans = Math.max(ans, curr);
        }

        return ans;
    }
}