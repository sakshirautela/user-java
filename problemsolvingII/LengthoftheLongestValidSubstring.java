import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthoftheLongestValidSubstring {
    public static void main(String[] args) {
        System.out.println(longestValidSubstring("leetcode", new ArrayList<>(Arrays.asList("de","le","e"))));
    }

    public static int longestValidSubstring(String word, List<String> forbidden) {
        int n = word.length();
        int result = 0;
        int i = 0, j = 0;
        while (j < n) {
            int[] data=isValid(word.substring(i, j + 1), j - i + 1, forbidden);
            if (data[1]==-1) {
                result = Math.max(j - i + 1, result);
                j++;
            } else {
                i=i+data[0]+1;
            }
        }
        return result;
    }

    private static int[] isValid(String s, int len, List<String> forbidden) {
        int res[]={-1,-1};
        for (String f : forbidden) {
            int l = f.length();
            if (l <= len) {
                int idx=s.indexOf(f);
                if ( idx!= -1) {
                    res[0]=idx;
                    res[1]=1;
                }
            }
        }
        return res;
    }
}