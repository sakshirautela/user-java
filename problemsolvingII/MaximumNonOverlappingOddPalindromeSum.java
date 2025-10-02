public class MaximumNonOverlappingOddPalindromeSum {
    public static void main(String[] args) {
        System.out.println(maxSum("qqqqqqqqqqqq"));
    }

    public static int maxSum(String s) {
        // code here
        int n = s.length();
        int i = 0;
        int lim = -1;
        int max=1;
        int max2=1;
        while (i < n) {
            int l = i - 1;
            int r = i + 1;
            int count = 1;
            while (l>=0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count += 2;
            }
            if(count>max){
                max2=max;
                max=count;
            } else if (count>max2) {
               max2=count;
            }

            i = r;
        }
        return max2+max;
    }

}
