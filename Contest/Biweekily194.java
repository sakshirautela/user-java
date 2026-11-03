package Contest;

import java.util.HashMap;
import java.util.HashSet;

public class Biweekily194 {
    static void main() {
        System.out.println(countMagicalPairsII("ddpu"));
    }

    public static int peakValleyDifference(int[] nums) {
        int n = nums.length;
        int peak = 0;
        int valley=0;
        for(int i=1;i<n-1;i++){
            if(nums[i]>nums[i+1] && nums[i-1]<nums[i]){
                peak+=nums[i];
            }
            if(nums[i]<nums[i+1] && nums[i-1]>nums[i]){
                valley+=nums[i];
            }
        }
        return peak-valley;
    }
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long sum = 0;
        int cont=0;
        for (int num : nums) {
            if (num >= minK && num <= maxK) {
                cont++;
            } else {
                sum += (((long) cont * (cont + 1))) / 2;
                cont = 0;
            }
        }
        if(cont>0){
            sum += (((long) cont * (cont + 1))) / 2;
        }
        return sum;
    }
        public static long countMagicalPairsII(String s) {
            int n = s.length();
            long ans=0;
            int[] f=new int[27];
            HashSet<Character> fs=new HashSet<>();
            for (int j = 0; j < n; j++) {
                fs.add(s.charAt(j));
                f[fs.size()]++;
                int[] b=new int[27];
                HashSet<Character> bs=new HashSet<>();
                for(int k = j+1; k < n; k++) {
                    bs.add(s.charAt(k));
                    b[bs.size()]++;
                }
                for(int i = 0; i < 27; i++) {
                    if(f[i]>0 && b[i]>0){
                        ans+= (long) f[i] *b[i];
                    }
                }
            }
          return ans;
        }
        public static int countMagicalPairs(String s) {
            int n = s.length();
            int[][] u = new int[n][n];
            for (int i = 0; i < n; i++) {
                HashSet<Character> set = new HashSet<>();
                for (int j = i; j < n; j++) {
                    set.add(s.charAt(j));
                    u[i][j] = set.size();
                }
            }
//            for (int i = 0; i < n; i++) {
//                System.out.print(u[i]+" ");
//            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i ; j < n; j++) {
                    int a=u[i][j];
                    if(a>(n-j)){
                        continue;
                    }
                    for (int k = j + 1; k < n; k++) {
                        int b=u[j+1][k];
                        if (a==b) {
                            ans++;
                        }else if(b>a){
                            break;
                        }
                    }
                }
            }
            // System.out.println();
            return ans;
        }
}
