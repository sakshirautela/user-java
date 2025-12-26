import java.util.HashMap;

public class ScrambleString {
    public static void main(String[] args) {
        System.out.println(isScramble("ab", "ba")); // true
    }
static HashMap<String,Boolean> map=new HashMap<>();
    public static boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() == 1) {
            return s1.equals(s2);
        }
String key=s1+"_"+s2;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int n = s1.length();
boolean res=false;
        for (int i = 1; i < n; i++) {

            boolean notSwapped =
                    isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                            isScramble(s1.substring(i), s2.substring(i));

            boolean swapped =
                    isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                            isScramble(s1.substring(i), s2.substring(0, n - i));

            if (notSwapped || swapped) {
                return true;
            }
        }
map.put(key,res);
        return res;
    }
    int[][][] memoize;
    public boolean isScrambleFast(String s1, String s2) {
        int hash1 = 0;
        int hash2 = 0;
        int n = s1.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < n; i++){
            hash1 += c1[i];
            hash2 += c2[i];
        }
        if (hash1 != hash2) return false;
        memoize = new int[n][n][n+1];
        return solve(c1, c2, hash1, hash2, 0, 0, n);
    }

    public boolean solve(char[] s1, char[] s2, int hash1, int hash2, int ind1, int ind2, int len){
        if (len == 1) return true;
        if (len == 2 && memoize[ind1][ind2][2] == 2){
            return true;
        }
        else if (len == 2 && memoize[ind1][ind2][2] == 1){
            return false;
        }
        else if (len == 2 && (s1[ind1] == s2[ind2] || s1[ind1] == s2[ind2+1])){
            memoize[ind1][ind2][2] = 2;
            return true;
        }
        else if (len == 2){
            memoize[ind1][ind2][2] = 1;
            return false;
        }

        int S1LH = 0, S2LH = 0;
        int S1RH = hash1, S2RH = hash2;
        int S2reverseRH = 0, S2reverseLH = hash2;

        for (int i = 0; i < len-1; i++){
            S1LH += s1[ind1 + i];
            S2LH += s2[ind2 + i];
            S1RH -= s1[ind1 + i];
            S2RH -= s2[ind2 + i];
            S2reverseRH += s2[ind2 + len-1-i];
            S2reverseLH -= s2[ind2 + len-1-i];
            if (S1LH == S2LH && S1RH == S2RH){
                int checkleft = memoize[ind1][ind2][i+1];
                int checkright = memoize[ind1+i+1][ind2+i+1][len-i-1];
                if (checkleft == 2 && checkright == 2){
                    return true;
                }
                else if (checkleft != 1 && checkright != 1){
                    boolean left = solve(s1, s2, S1LH, S2LH, ind1, ind2, i+1);
                    if (left){
                        memoize[ind1][ind2][i+1] = 2;
                        boolean right = solve(s1, s2, S1RH, S2RH, ind1+i+1, ind2+i+1, len-i-1);
                        if (right){
                            memoize[ind1+i+1][ind2+i+1][len-i-1] = 2;
                            return true;
                        }
                        else{
                            memoize[ind1+i+1][ind2+i+1][len-i-1] = 1;
                        }
                    }
                    else{
                        memoize[ind1][ind2][i+1] = 1;
                    }
                }
            }
            if (S1LH == S2reverseRH && S1RH == S2reverseLH){
                int checkleft = memoize[ind1][ind2+len-i-1][i+1];
                int checkright = memoize[ind1+i+1][ind2][len-i-1];
                if (checkleft == 2 && checkright == 2){
                    return true;
                }
                else if (checkleft != 1 && checkright != 1){
                    boolean left = solve(s1, s2, S1LH, S2reverseRH, ind1, ind2+len-i-1, i+1);
                    if (left){
                        memoize[ind1][ind2+len-i-1][i+1] = 2;
                        boolean right = solve(s1, s2, S1RH, S2reverseLH, ind1+i+1, ind2, len-i-1);
                        if (right) {
                            memoize[ind1+i+1][ind2][len-i-1] = 2;
                            return true;
                        }
                        else{
                            memoize[ind1+i+1][ind2][len-i-1] = 1;
                        }
                    }
                    else{
                        memoize[ind1][ind2+len-i-1][i+1] = 1;
                    }
                }
            }
        }
        return false;
    }
}
