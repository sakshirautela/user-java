import java.util.Arrays;

public class DiffrenceChecks {
    public static void main(String[] args) {
        System.out.println();
    }
    public static int minDifference(String[] arr) {
        // code here
        int n=arr.length;
        int time[]=new int[n];
        for (int i = 0; i < n; i++) {
            String s=arr[i];

            int hr=Integer.parseInt(s.substring(0,2));
            int min=Integer.parseInt(s.substring(3,5));
            int sec=Integer.parseInt(s.substring(6,8));
            time[i]=(hr*60*60+min*60+sec);
        }
        Arrays.sort(time);
        int result=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            result=Math.min(result,(time[i]-time[i-1]));
        }
        int circularDiff = (time[0] + 24 * 3600) - time[n - 1];
        result = Math.min(result, circularDiff);

        return result;
    }
}
