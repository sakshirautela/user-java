import java.util.Arrays;

public class ValidParenthesisString {
    static void main() {
        System.out.println(checkValidString("(((((*)))**"));
    }

    private static boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return checkValidStringHeleper(0, s, n, 0,dp);
    }

    private static boolean checkValidStringHeleper(int open, String s, int n, int i, int[][] dp) {
        if (i == n) {
            return open == 0 ;
        }
        if(dp[open][i]!=-1){
            return dp[open][i] == 1;
        }
        boolean res = false;
        if (s.charAt(i) == '(') {
            res =  checkValidStringHeleper(open+1, s, n, i + 1, dp);
        } else if (s.charAt(i) == ')') {
            if(open>0){
                res =checkValidStringHeleper(open-1, s, n, i + 1, dp);
            }else{
                return false;
            }
        } else {
             res|=checkValidStringHeleper(open+1, s, n, i + 1, dp);
            if (open>0){
                res|=checkValidStringHeleper(open-1, s, n, i + 1, dp);
            }
            res|=checkValidStringHeleper(open, s, n, i + 1, dp);
        }
         dp[open][i]= res?1:0;
        return res;
    }

}
