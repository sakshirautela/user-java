import java.util.Arrays;

public class CheckifAlltheIntegersinaRangeAreCovered {
    static void main() {
        System.out.println(isCovered(new int[][]{{1,2},{3,4},{5,6}},2,5));
    }
    public static boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges,(a, b)->(a[0]==b[0])?b[1]-a[1]:a[0]-b[0]);
        int prev=ranges[0][0];
        int end=ranges[0][1];
        for(int[] range:ranges){
            if(prev<=left && end>=right){
                return true;
            }
            if(end+1<range[0]){
                end=range[1];
                prev=range[0];
            }
            prev=Math.min(prev,range[0]);
            end=Math.max(end,range[1]);
        }
        if(prev>left || end<right){
            return false;
        }
        return true;
    }
        public boolean isCoveredFast(int[][] ranges, int left, int right) {
            int maxi = 0;
            for(int i=0;i<ranges.length;i++) maxi = Math.max(maxi, ranges[i][1]);
            if(right > maxi) return false;
            int diff[] = new int[maxi + 1];
            for(int i=0;i<ranges.length;i++){
                int start = ranges[i][0];
                int end = ranges[i][1];
                diff[start] += 1;
                if(end+1 <= maxi) diff[end+1] -= 1;
            }
            for(int i=1;i<=maxi;i++){
                diff[i] += diff[i-1];
                if(i >= left && i <= right && diff[i] == 0) return false;
            }
            return true;
        }
}