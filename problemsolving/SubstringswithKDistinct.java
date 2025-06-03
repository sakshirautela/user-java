import java.util.HashMap;

public class SubstringswithKDistinct {
    public static void main(String[] args) {
        System.out.println(countSubstr("zatpvvsnhx", 1));
    }

    static int countSubstrGFG(String s, int k) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            // Array to check if a character
            // is present in substring i..j
            boolean[] map = new boolean[26];
            int distinctCnt = 0;

            for (int j = i; j < n; j++) {

                // If new character is present,
                // increment distinct count.
                if (!map[s.charAt(j) - 'a']) {
                    map[s.charAt(j) - 'a'] = true;
                    distinctCnt++;
                }

                // If distinct count is equal to k.
                if (distinctCnt == k)
                    ans++;
            }
        }

        return ans;
    }

    // Java program to find substrings
    // with K Distinct characters
    // Function which finds the number of
    // substrings with atmost k Distinct
    // characters.
    static int count(String s, int k) {
        int n = s.length();
        int res = 0;

        // Use sliding window technique
        int[] freq = new int[26];
        int distinctCnt = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {

            // Expand window and add character
            freq[s.charAt(j) - 'a']++;
            if (freq[s.charAt(j) - 'a'] == 1)
                distinctCnt++;

            // Shrink window if distinct characters exceed k
            while (distinctCnt > k) {
                freq[s.charAt(i) - 'a']--;
                if (freq[s.charAt(i) - 'a'] == 0)
                    distinctCnt--;
                i++;
            }

            // Add number of valid substrings ending at j
            res += j - i + 1;
        }

        return res;
    }

    // Function to find the number of substrings
    // with exactly k Distinct characters.
    static int countSubstr(String s, int k) {
        int res = 0;
        // Subtract substrings with at most
        // k-1 distinct characters from substrings
        // with at most k distinct characters
        res = count(s, k) - count(s, k - 1);

        return res;
    }

    static int countSubstrWrong(String s, int k) {
        // your code here
        int n = s.length();
        int res = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        int i = 0, j = 0;
        while (i <= j && j < n) {
            if (freq.size() < k || (j > 0 && s.charAt(j) == s.charAt(j - 1))) {
                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);
                j++;
                if (freq.size() == k) {
                    res += j - i;
                }

            } else {
                freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) - 1);
                if (freq.get(s.charAt(i)) == 0) {
                    freq.remove(s.charAt(i));
                }
                i++;
            }
        }
        return res;
    }
}