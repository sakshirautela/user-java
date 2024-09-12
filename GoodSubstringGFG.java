public class GoodSubstringGFG {
    public static long cntGood(String s) {
        long res = 0;
        int n = s.length();
        int countNonZero = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                countNonZero++;
            }
            else if ((s.charAt(i) - '0') % 2 != 0) {
                res = res+i+1-countNonZero;
            }
        }
        
        return res;
    }
    public static void main(String args[]) {
        System.out.println(cntGood("999"));
    }
}