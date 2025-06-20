
public class LongestSpaninTwoBinaryArrays {
    public static void main(String[] args) {
        System.out.println(longestCommonSum(new int[]{},new int[]{}));
    }
    public static int longestCommonSum(int[] a1, int[] a2) {
        // Code here
        int n=a1.length;
        for(int i=1;i<n;i++){
            a1[i]+=a1[i-1];
        }
         for(int i=1;i<n;i++){
            a2[i]+=a2[i-1];
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            int a=0;
            int b=0;
            for(int j=i;j<n;j++){
                a+=a1[j];
                b+=a2[j];
                if(a==b){
                    res=Math.max(j-i,res);
                }
            }
        }
        return res;
    }
}