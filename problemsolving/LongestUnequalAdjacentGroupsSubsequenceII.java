import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestUnequalAdjacentGroupsSubsequenceII {
    @SuppressWarnings("unused")
    public List<String> getWordsInLongestSubsequence2(String[] words, int[] groups) {
        int n = words.length;
        Map<Long, List<Integer>> map = new HashMap<>();
        
        int[] ansNext = new int[n];
        int[] lengths = new int[n];
        
        int ansIndex = 0;

        Arrays.fill(ansNext, n);

        for (int left = n - 1; left >= 0; left--) {
            String word = words[left];
            int len = word.length();
            int res = 1;
            long completeMask = 0l;
            long[] masks = new long[len];
            for (int i = 0; i < len; i++) {
                completeMask |= masks[i] = (long)(word.charAt(i) - 'a' + 1) << (5 * i);
            }
            for (int i = 0; i < len; i++) {
                long targetMask = completeMask ^ masks[i];
                List<Integer> queue = map.computeIfAbsent(targetMask, (j) -> new ArrayList<>());
                for (int idx : queue) {
                    if (res >= lengths[idx] + 1 || groups[idx] == groups[left] ) continue;
                    res = lengths[idx] + 1;
                    ansNext[left] = idx;
                }
                queue.add(left);
            }
            lengths[left] = res;
            if (lengths[ansIndex] < res) ansIndex = left;
        }

        List<String> ans = new ArrayList<>(lengths[ansIndex]);
        for (int i = ansIndex; i < n; i = ansNext[i]) {
            ans.add(words[i]);
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(getWordsInLongestSubsequence(new String[] { "aab", "ca", "cbd" }, new int[] { 3, 3, 2 }));
    }

    public static List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int prev[] = new int[n];
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxIdx=0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(getHammingOrEqual(words[i], words[j])&&  dp[j] + 1 > dp[i]  && groups[i]!=groups[j]){
                    dp[i]=dp[j]+1;
                    prev[i]=j;
                }
            }
            if(dp[i]>dp[maxIdx]){
                maxIdx=i;
            }
        }
        List<String> li = new ArrayList<>();
        for( int i=maxIdx;i>=0;i=prev[i]){
            li.add(words[i]);
        }
        Collections.reverse(li);
        return li;
    }

    private static boolean getHammingOrEqual(String string, String string2) {
        if(string.length()!=string2.length()){
            return false;
        }
        int count = 0;
        int n = string.length();
        for (int i = 0; i < n; i++) {
            if (string.charAt(i) != string2.charAt(i)) {
                count++;
            }
            if (count >= 2) {
                return false;
            }
        }
        return count==1;
    }
}