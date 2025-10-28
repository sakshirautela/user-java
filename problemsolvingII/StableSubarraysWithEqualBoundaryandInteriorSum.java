public class StableSubarraysWithEqualBoundaryandInteriorSum {
    public static void main(String[] args) {
        System.out.println(countStableSubarrays(new int[]{9,3,3,3,9}));
    }
        public static long countStableSubarrays(int[] capacity) {
int n=capacity.length;
long result=0;
            for (int i = 0; i <n ; i++) {
                long sum=0;
                for (int j = i+1; j < n-1; j++) {
                    sum+=capacity[j];

                    if(j-i>=1&& (sum==capacity[i]&&sum==capacity[j+1])){
                        result++;
                    }
                }
            }
            return result;
        }
}
